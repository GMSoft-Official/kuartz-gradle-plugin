package com.kuartz.gradle.plugin

import com.kuartz.gradle.plugin.tasks.CleanQueryDslDirectory
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

import static org.hamcrest.CoreMatchers.equalTo
import static org.hamcrest.MatcherAssert.assertThat

/**
 @author Kutay Celebi
 @since 6.10.2019
 */
class CleanQueryDslSourceDirTest {
    private Project project
    private CleanQueryDslDirectory cleanTask

    @BeforeMethod
    void setup() {
        project = ProjectBuilder.builder().build()
        project.plugins.apply(KuartzPlugin.class)
        project.evaluate()
        cleanTask = project.tasks.getByName(CleanQueryDslDirectory.TASK_NAME) as CleanQueryDslDirectory
    }

    @Test
    void testCreateSourceFolders() {

        def testSource = "src/test/resources"
        project.kuartzplugin.qdslSourceDir = testSource
        cleanTask.cleanQdslSourceDir()

        File sourceFile = new File(testSource)

        ArrayList<String> queryPathList = new FileNameByRegexFinder().getFileNames(sourceFile.path, '.*query$')

        boolean isPackageDeleted = true
        def iterator = queryPathList.iterator()
        if (iterator.hasNext()) {
            while (iterator.hasNext()) {
                def file = new File(iterator.next())
                if (file.exists()) {
                    isPackageDeleted = false
                    break
                }
            }
        }
        assertThat(isPackageDeleted, equalTo(true))

    }
}
