package org.ifno_software.shadow_fiend

import org.gradle.api.Project
import org.gradle.api.Plugin

class SfPlugin implements Plugin<Project> {
    void apply(Project target) {
        target.task('hello', type: GreetingTask)

    }
}
