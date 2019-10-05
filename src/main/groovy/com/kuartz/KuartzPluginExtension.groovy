package com.kuartz

import com.kuartz.constants.KuartzGradlePluginConstants

/**
 @author Kutay Celebi
 @since 29.09.2019
 */
class KuartzPluginExtension {

    boolean jpa = false

    boolean hibernate = false
    boolean querydslDefault = false

    String qdslSourceDir = KuartzGradlePluginConstants.QDSL_SOURCE_DIR

    List aptOptions = []

    String processors() {

        List procs = []

        if (hibernate) {
            procs.add(KuartzGradlePluginConstants.HIBERNATE_PROCESSOR)
        }

        if (jpa) {
            procs.add(KuartzGradlePluginConstants.JPA_PROCESSOR)
        }

        if (querydslDefault) {
            procs.add(KuartzGradlePluginConstants.QDSL_LIBRARY)
        }

        return procs.join(",")
    }

}
