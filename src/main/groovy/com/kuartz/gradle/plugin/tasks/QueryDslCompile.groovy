package com.kuartz.gradle.plugin.tasks

import com.kuartz.gradle.plugin.constants.KuartzGradlePluginConstants
import org.gradle.api.plugins.WarPlugin
import org.gradle.api.tasks.compile.JavaCompile
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 @author Kutay Celebi
 @since 29.09.2019
 */
class QueryDslCompile extends JavaCompile {

    public static final Logger LOG = LoggerFactory.getLogger(QueryDslCompile.class)

    public static final String TASK_NAME = "compileQueryDsl"

    QueryDslCompile() {

        setSource(project.sourceSets.main.java)

//        if (project.plugins.hasPlugin(WarPlugin.class)) {
//            project.configurations {
//                kuartzplugin.extendsFrom compile, providedRuntime, providedCompile
//            }
//        } else {
//            project.configurations {
//                kuartzplugin.extendsFrom compileClasspath
//            }
//        }

        project.configurations {
            kuartzplugin.extendsFrom compileClasspath
        }

        project.afterEvaluate {
            setClasspath(project.configurations.compile)
            setDestinationDir(new File(KuartzGradlePluginConstants.DEFAULT_QDSL_SOURCE_DIR))
        }
    }
}
