package com.kuartz.tasks

import com.kuartz.KuartzPlugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 @author Kutay Celebi
 @since 29.09.2019
 */
class InitQueryDirectory extends DefaultTask {

    public static final Logger LOG = LoggerFactory.getLogger(InitQueryDirectory.class)

    public static final String TASK_NAME = "initSourceDir"

    InitQueryDirectory() {
        this.group = KuartzPlugin.TASK_GROUP
    }

    @TaskAction
    createSourceFolders() {

        String sourcePath = project.kuartzplugin.qdslSourceDir
        File sourceFile = new File(sourcePath)

        ArrayList<String> entityPathList = new FileNameByRegexFinder().getFileNames(sourceFile.path, '.*entity$')


        def iterator = entityPathList.iterator()
        while (iterator.hasNext()) {
            String path = iterator.next().concat("\\query")
            def file = new File(path)
            if (!file.exists()) {
                file.mkdirs()
                LOG.info("{} path has created", path)
                logger.info("test123")
                project.logger.info('bu da mi gol degil')
            } else {
                LOG.info("{} path already exists", path)
                logger.info("test123")
                project.logger.info('bu da mi gol degil')
            }
        }


    }
}
