/*
 * Copyright 2015 Maksym Palamarchuk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ifno_software.shadow_fiend

import com.google.common.annotations.VisibleForTesting
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.ProjectConfigurationException
import org.gradle.api.file.SourceDirectorySet
import org.gradle.api.internal.file.FileResolver
import org.gradle.api.internal.plugins.DslObject
import org.gradle.api.internal.tasks.DefaultScalaSourceSet
import org.gradle.api.internal.tasks.DefaultSourceSet
import org.gradle.api.tasks.SourceSet
import org.gradle.util.ConfigureUtil

import javax.inject.Inject

class ShadowFiendPlugin implements Plugin<Project> {
    private final FileResolver fileResolver
    private Project project
    private Object androidPlugin
    private Object androidExtension
    private boolean isLibrary
    private File workDir
    private final ShadowFiendExtension extension = new ShadowFiendExtension()
    @VisibleForTesting
    final Map<String, SourceDirectorySet> sourceDirectorySetMap = new HashMap<>()

    @Inject
    ShadowFiendPlugin(FileResolver fileResolver) {
        this.fileResolver = fileResolver
    }

    void apply(Project project, Object androidExtension) {
        this.project = project
        if (project.plugins.hasPlugin("android-library")) {
            isLibrary = true
            androidPlugin = project.plugins.findPlugin("android-library")
        } else {
            isLibrary = false
            androidPlugin = project.plugins.findPlugin("android")
        }
        this.androidExtension = androidExtension
        this.workDir = new File(project.buildDir, "android-db-contracts")
        project.extensions.create("shadowFiend", ShadowFiendExtension)

        updateAndroidExtension()
        updateAndroidSourceSetsExtension()

        androidExtension.buildTypes.whenObjectAdded { updateAndroidSourceSetsExtension() }
        androidExtension.productFlavors.whenObjectAdded { updateAndroidSourceSetsExtension() }
        androidExtension.signingConfigs.whenObjectAdded { updateAndroidSourceSetsExtension() }

        project.afterEvaluate {
            updateAndroidSourceSetsExtension()
            def allVariants = androidExtension.testVariants + (isLibrary ? androidExtension.libraryVariants : androidExtension.applicationVariants)
            allVariants.each { variant ->
                addAndroidCodeGenerateTask(variant)
            }
        }

        project.tasks.findByName("preBuild").doLast {
            workDir.mkdirs();
        }
    }

    /**
     * Registers the plugin to current project.
     *
     * @param project currnet project
     * @param androidExtension extension of Android Plugin
     */
    public void apply(Project project) {
        if (!["com.android.application",
              "android",
              "com.android.library",
              "android-library",
              "com.android.model.application",
              "com.android.model.library"].any { project.plugins.findPlugin(it) }) {
            throw new ProjectConfigurationException("Please apply 'com.android.application' or 'com.android.library' plugin before applying 'shadow-fiend' plugin", null)
        }
        apply(project, project.extensions.getByName("android"))
    }

    void updateAndroidExtension() {
        androidExtension.metaClass.getShadowFiend = { extension }
        androidExtension.metaClass.shadowFiend = { configureClosure ->
            ConfigureUtil.configure(configureClosure, extension)
            androidExtension
        }
    }

    void updateAndroidSourceSetsExtension() {
        androidExtension.sourceSets.each { sourceSet ->
            println("androidExtension.sourceSets.each => " + sourceSet.name)
            if (sourceDirectorySetMap.containsKey(sourceSet.name)) {
                return
            }

            ShadowFiendSourceSet shadowFiendSourceSet = new DefaultShadowFiendSourceSet(sourceSet.displayName+"Sql", fileResolver)
            new DslObject(sourceSet).convention.plugins.put("shadowFiend", shadowFiendSourceSet)
            def sqlSrcDir = ["src", sourceSet.name, "sql"].join(File.separator)
            shadowFiendSourceSet.sql.srcDir(sqlSrcDir)
            sourceSet.java.srcDir(sqlSrcDir)
        }
    }

    void addAndroidCodeGenerateTask(Object variant) {
        def javaCompileTask = variant.javaCompile

        def task = project.tasks.create("generate${variant.name.capitalize()}DbContracts", ShadowFiendTask)
        javaCompileTask.dependsOn(task)

        def variantWorkDir = getVariantWorkDir(variant)
        def sqlSources = variant.variantData.variantConfiguration.sortedSourceProviders.inject([]) { acc, val ->
            acc + val.sql.srcDirs
        }
        println("sqlSources: " + sqlSources)
        task.source = sqlSources
        task.packageName = project.extensions.shadowFiend.packageName
        task.authority = project.extensions.shadowFiend.authority
        task.outputDirectory = variantWorkDir
        variant.addJavaSourceFoldersToModel(variantWorkDir)

        task.execute()
        project.logger.lifecycle(task.path)
    }

    File getVariantWorkDir(Object variant) {
        new File([workDir, variant.name].join(File.separator))
    }
}
