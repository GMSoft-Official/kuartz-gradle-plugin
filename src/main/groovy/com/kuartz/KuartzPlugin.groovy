package com.kuartz

import com.kuartz.constants.KuartzGradlePluginConstants
import com.kuartz.tasks.CleanQueryDslDirectory

import com.kuartz.tasks.QueryDslCompile
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

    public static final Logger LOG = Logging.getLogger(KuartzPlugin.class)

    void apply(Project project) {
        LOG.info("Kuartz plugin yukleniyor")

        if (!project.getPlugins().hasPlugin(JavaPlugin)) {
            project.getPlugins().apply(JavaPlugin)
        }

        project.getExtensions().create(KuartzGradlePluginConstants.GRADLE_EXTENSION_NAME, KuartzPluginExtension)

        project.task(type: CleanQueryDslDirectory, CleanQueryDslDirectory.TASK_NAME)
        project.task(type: QueryDslCompile, QueryDslCompile.TASK_NAME)

        // set compile task group
        project.tasks.getByName(QueryDslCompile.TASK_NAME).group = KuartzGradlePluginConstants.QDSL_TASK_GROUP

        // qdsl dir depends on clean
        project.tasks.clean.dependsOn project.tasks.getByName(CleanQueryDslDirectory.TASK_NAME)

        project.afterEvaluate {
            addLibrary(project)
            applyCompilerOptions(project)
        }

    }

    private static void applyCompilerOptions(Project project) {
        project.tasks.compileQueryDsl.options.compilerArgs += [
                "-proc:only",
                "-processor", project.kuartzplugin.processors(),
                "-Aquerydsl.suffix=" + project.kuartzplugin.entityQuerySuffix,
                "-Aquerydsl.prefix=" + project.kuartzplugin.entityQueryPrefix,
                "-Aquerydsl.packageSuffix=" + project.kuartzplugin.entityQueryPackageSuffix
        ]

        project.tasks.compileQueryDsl.options.annotationProcessorPath = project.configurations.kuartzplugin

        if (project.kuartzplugin.aptOptions.size() > 0) {
            for (aptOption in project.kuartzplugin.aptOptions) {
                project.tasks.compileQueryDsl.options.compilerArgs << "-A" + aptOption
            }
        }
    }

    private void addLibrary(Project project) {
        def library = project.extensions.kuartzplugin.aptLibrary
        project.dependencies {
            compile library
        }
    }
}
