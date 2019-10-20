package com.kuartz.gradle.plugin


import com.kuartz.gradle.plugin.constants.KuartzGradlePluginConstants

/**
 @author Kutay Celebi
 @since 29.09.2019
 */
class KuartzPluginExtension {

    boolean jpa = true

    // Default qdsl apt library
    String aptLibrary = KuartzGradlePluginConstants.DEFAULT_QDSL_LIBRARY

    // querydsl
    String qdslSourceDir = KuartzGradlePluginConstants.DEFAULT_QDSL_SOURCE_DIR
    String entityQueryPrefix = ""
    String entityQuerySuffix = KuartzGradlePluginConstants.DEFAULT_QDSL_ENTITY_SUFFIX
    String entityQueryPackageSuffix = KuartzGradlePluginConstants.DEFAULT_QDSL_PACKAGE_SUFFIX

    List aptOptions = []

    String processors() {

        List procs = []

        if (jpa) {
            procs.add(KuartzGradlePluginConstants.JPA_PROCESSOR)
        }

        return procs.join(",")
    }

}
