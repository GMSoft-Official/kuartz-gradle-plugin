package com.kuartz

import com.kuartz.constants.KuartzGradlePluginConstants
import com.kuartz.tasks.InitQueryDirectory
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.logging.Logger
import org.gradle.api.logging.Logging
import org.gradle.api.plugins.JavaPlugin

/**
 @author Kutay Celebi
 @since 29.09.2019
 */
class KuartzPlugin implements Plugin<Project> {

    public static final String TASK_GROUP = "KuartzPlugin"

    public static final Logger LOG = Logging.getLogger(KuartzPlugin.class)

    void apply(Project project) {
        LOG.info("Kuartz plugin yukleniyor")

        if (!project.getPlugins().hasPlugin(JavaPlugin)) {
            project.getPlugins().apply(JavaPlugin)
        }

        project.getExtensions().create(KuartzGradlePluginConstants.GRADLE_EXTENSION_NAME, KuartzPluginExtension)

        project.task(type: InitQueryDirectory,InitQueryDirectory.TASK_NAME)

        String path = project.getExtensions().getByName(KuartzGradlePluginConstants.GRADLE_EXTENSION_NAME).getProperties().get('qdslSourceDir')

        project.file(path)

    }

}
