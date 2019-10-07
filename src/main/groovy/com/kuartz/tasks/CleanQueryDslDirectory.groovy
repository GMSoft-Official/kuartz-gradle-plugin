package com.kuartz.tasks

import com.kuartz.constants.KuartzGradlePluginConstants
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 @author Kutay Celebi
 @since 6.10.2019
 */
class CleanQueryDslDirectory extends DefaultTask {

    public static final String TASK_NAME = "cleanQdslDir"

    CleanQueryDslDirectory() {
        this.group = KuartzGradlePluginConstants.QDSL_TASK_GROUP
    }

    @TaskAction
    cleanQdslSourceDir(){

        String sourcePath = project.kuartzplugin.qdslSourceDir
        File sourceFile = new File(sourcePath)

        ArrayList<String> queryPathList = new FileNameByRegexFinder().getFileNames(sourceFile.path, '.*'+ project.kuartzplugin.entityQueryPackageSuffix +'$')


        def iterator = queryPathList.iterator()
        while (iterator.hasNext()) {
            String path = iterator.next()
            def file = new File(path)
            if (file.exists()) {
                file.deleteDir()
            }
        }
    }
}
