package com.kuartz


import com.kuartz.tasks.QueryDslCompile
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

/**
 @author Kutay Celebi
 @since 6.10.2019
 */
class QueryDslCompileTest {

    private Project project
    private QueryDslCompile compileTask

    @BeforeMethod
    void setup() {
        project = ProjectBuilder.builder().build()
        project.plugins.apply(KuartzPlugin.class)
        project.evaluate()

        compileTask = project.tasks.getByName(QueryDslCompile.TASK_NAME) as QueryDslCompile
        compileTask.includes += ["**/entity/*.java"]
    }

    @Test
    void testCreateSourceFolders() {

    }
}

