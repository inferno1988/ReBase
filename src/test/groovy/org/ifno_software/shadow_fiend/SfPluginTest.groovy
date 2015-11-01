package org.ifno_software.shadow_fiend

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder

/**
 * Created by inferno on 11/1/15.
 */
class SfPluginTest extends GroovyTestCase {
    void setUp() {
        super.setUp()

    }

    void tearDown() {

    }

    void testApply() {
        Project project = ProjectBuilder.builder().build()
        project.pluginManager.apply 'org.ifno_software.shadow_fiend'

        assertTrue(project.tasks.hello instanceof GreetingTask)

        project.tasks.hello.execute()
    }
}
