package org.ifno_software.shadow_fiend

import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.gradle.api.Action
import org.gradle.api.file.FileTree
import org.gradle.api.file.SourceDirectorySet
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.SkipWhenEmpty
import org.gradle.api.tasks.SourceTask
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.incremental.IncrementalTaskInputs
import org.gradle.api.tasks.incremental.InputFileDetails
import org.gradle.util.GFileUtils

import java.util.concurrent.atomic.AtomicBoolean

class ShadowFiendTask extends SourceTask {
    private File outputDirectory;
    private SourceDirectorySet sourceDirectorySet;
    private String authority;
    private String packageName;

    @TaskAction
    def execute(IncrementalTaskInputs inputs) {
        final Set<File> sqlFiles = new HashSet<File>();
        final Set<File> sourceFiles = getSource().getFiles();
        final AtomicBoolean cleanRebuild = new AtomicBoolean();
        //TODO: Implement extension properties changed handler
        cleanRebuild.set(true);
        inputs.outOfDate(
                new Action<InputFileDetails>() {
                    public void execute(InputFileDetails details) {
                        File input = details.getFile();
                        if (sourceFiles.contains(input)) {
                            sqlFiles.add(input);
                        } else {
                            // classpath change?
                            cleanRebuild.set(true);
                        }
                    }
                }
        );
        inputs.removed(new Action<InputFileDetails>() {
            @Override
            public void execute(InputFileDetails details) {
                if (details.isRemoved()) {
                    cleanRebuild.set(true);
                }
            }
        });

        if (cleanRebuild.get()) {
            GFileUtils.cleanDirectory(outputDirectory);
            sqlFiles.addAll(sourceFiles);
        }

        sqlFiles.each { File file ->
            def lexer = new SQLiteLexer(new ANTLRInputStream(file.text))
            def tokenStream = new CommonTokenStream(lexer)
            def parser = new SQLiteParser(tokenStream)
            def parseContext = parser.parse();
            def parseTreeWalker = new ParseTreeWalker()
            SQLiteListener listener = new SQLiteGroovyListener(outputDirectory, authority, packageName)
            parseTreeWalker.walk(listener, parseContext)
        }

    }


    /**
     * Sets the source for this task. Delegates to {@link SourceTask#setSource(Object)}.
     *
     * If the source is of type {@link SourceDirectorySet}, then the relative path of each source grammar files
     * is used to determine the relative output path of the generated source
     * If the source is not of type {@link SourceDirectorySet}, then the generated source files end up
     * flattened in the specified output directory.
     *
     * @param source The source.
     */
    @Override
    public void setSource(Object source) {
        super.setSource(source);
        if (source instanceof SourceDirectorySet) {
            this.sourceDirectorySet = (SourceDirectorySet) source;
        }
    }

    /**
     * Returns the source for this task, after the include and exclude patterns have been applied. Ignores source files which do not exist.
     *
     * @return The source.
     */
    // This method is here as the Gradle DSL generation can't handle properties with setters and getters in different classes.
    @InputFiles
    @SkipWhenEmpty
    public FileTree getSource() {
        return super.getSource();
    }

    /**
     * Returns the directory to generate the parser source files into.
     *
     * @return The output directory.
     */
    @OutputDirectory
    public File getOutputDirectory() {
        return outputDirectory;
    }

    /**
     * Specifies the directory to generate the parser source files into.
     *
     * @param outputDirectory The output directory. Must not be null.
     */
    public void setOutputDirectory(File outputDirectory) {
        this.outputDirectory = outputDirectory;
    }

    String getAuthority() {
        return authority
    }

    void setAuthority(String authority) {
        this.authority = authority
    }

    String getPackageName() {
        return packageName
    }

    void setPackageName(String packageName) {
        this.packageName = packageName
    }
}
