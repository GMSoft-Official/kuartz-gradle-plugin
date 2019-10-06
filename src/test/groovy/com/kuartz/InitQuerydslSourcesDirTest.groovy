package com.kuartz

import com.kuartz.tasks.InitQueryDirectory
import org.gradle.api.Project
import org.gradle.api.logging.Logging
import org.gradle.internal.impldep.org.testng.log4testng.Logger
import org.gradle.testfixtures.ProjectBuilder
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

import static org.hamcrest.CoreMatchers.equalTo
import static org.hamcrest.MatcherAssert.assertThat

/**
 * @author holgerstolzenberg
 * @since 1.0.0
 */
class InitQuerydslSourcesDirTest {

    private Project project
    private InitQueryDirectory createTask

    @BeforeMethod
    void setup() {
        project = ProjectBuilder.builder().build()
        project.plugins.apply(KuartzPlugin.class)
        project.evaluate()

        createTask = project.tasks.getByName(InitQueryDirectory.TASK_NAME) as InitQueryDirectory
    }

    @Test
    void testCreateSourceFolders() {

        def testSource = "src/test/resources"
        project.kuartzplugin.qdslSourceDir = testSource
        createTask.createSourceFolders()

        File sourceFile = new File(testSource)

        ArrayList<String> entityPathList = new FileNameByRegexFinder().getFileNames(sourceFile.path, '.*query$')

        boolean isPackageExists = false
        def iterator = entityPathList.iterator()
        while (iterator.hasNext()) {
            def file = new File(iterator.next())
            if (file.exists()) {
                isPackageExists = true
            } else {
                isPackageExists = false
                break
            }
        }
        assertThat(isPackageExists, equalTo(true))

    }

    @Test
    void testGroup() {
        assertThat(createTask.group, equalTo(QuerydslPlugin.TASK_GROUP))
    }

    @Test
    void testDescription() {
        assertThat(createTask.description, equalTo(InitQuerydslSourcesDir.DESCRIPTION))
    }
}
