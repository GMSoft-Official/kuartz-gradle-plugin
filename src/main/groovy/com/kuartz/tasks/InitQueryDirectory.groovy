package com.kuartz.tasks

import com.kuartz.KuartzPlugin
import org.gradle.api.DefaultTask
import org.gradle.api.file.FileTree
import org.gradle.api.tasks.TaskAction

/**
 @author Kutay Celebi
 @since 29.09.2019
 */
class InitQueryDirectory extends DefaultTask {

    public static final String TASK_NAME = "initSourceDir"

    InitQueryDirectory() {
        this.group = KuartzPlugin.TASK_GROUP
    }

    @TaskAction
    createSourceFolders() {

        List<String> files = new FileNameByRegexFinder().getFileNames(project.projectDir.path, '\\.*Entity\\.*java')

        FileTree source = project.fileTree('/src/main/java').matching {
            include '**/*Entity.java'
        }

        List<String> entityPaths = new ArrayList<String>()
        Iterator<String> iterator = source.iterator()
        while (iterator.hasNext()) {
            if (!entityPaths.contains(iterator.next())) {
                entityPaths.add(iterator.next())
            }
        }

        println entityPaths.join(",")
    }
}
