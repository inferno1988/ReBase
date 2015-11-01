package org.ifno_software.shadow_fiend

import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class GreetingTask extends DefaultTask {
    String greeting = 'hello from GreetingTask'

    final String testQuery = "CREATE TABLE IF NOT EXISTS projects (\n" +
            "  key TEXT NOT NULL UNIQUE,\n" +
            "  id INTEGER PRIMARY KEY NOT NULL,\n" +
            "  name TEXT NOT NULL,\n" +
            "  description TEXT,\n" +
            "  public NUMERIC,\n" +
            "  type TEXT\n" +
            ");"

    final String testQuery1 = "CREATE TABLE IF NOT EXISTS pull_requests (\n" +
            "  id INTEGER PRIMARY KEY NOT NULL,\n" +
            "  version INTEGER,\n" +
            "  title TEXT NOT NULL,\n" +
            "  description TEXT,\n" +
            "  state TEXT,\n" +
            "  open NUMERIC,\n" +
            "  closed NUMERIC,\n" +
            "  createdDate INTEGER,\n" +
            "  updatedDate INTEGER,\n" +
            "  locked NUMERIC,\n" +
            "  author_id INTEGER NOT NULL,\n" +
            "  repo_id INTEGER NOT NULL,\n" +
            "  commentsCount INTEGER,\n" +
            "  FOREIGN KEY(author_id) REFERENCES authors(id),\n" +
            "  FOREIGN KEY(repo_id) REFERENCES repos(id)\n" +
            ");"

    @TaskAction
    def greet() {
        println greeting
        def lexer = new SQLiteLexer(new ANTLRInputStream(testQuery + testQuery1))
        def tokenStream = new CommonTokenStream(lexer)
        def parser = new SQLiteParser(tokenStream)
        def parseContext = parser.parse();
        println(parseContext)
        def parseTreeWalker = new ParseTreeWalker()
        SQLiteListener listener = new SQLiteGroovyListener()
        parseTreeWalker.walk(listener, parseContext)
    }
}
