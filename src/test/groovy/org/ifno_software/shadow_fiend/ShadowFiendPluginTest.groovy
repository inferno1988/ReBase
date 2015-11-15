package org.ifno_software.shadow_fiend

import org.gradle.api.Project
import org.gradle.api.plugins.JavaBasePlugin
import org.gradle.testfixtures.ProjectBuilder

/**
 * Created by inferno on 11/1/15.
 */
class ShadowFiendPluginTest extends GroovyTestCase {
    void setUp() {
        super.setUp()

    }

    void tearDown() {

    }

    void testApply() {
        Project project = ProjectBuilder.builder().build()
        project.apply plugin: JavaBasePlugin
        project.pluginManager.apply 'org.ifno_software.shadow_fiend'


        //assertTrue(project.tasks.generateDbContracts instanceof ShadowFiendTask)

        project.tasks.generateDbContracts.execute()
    }
}
