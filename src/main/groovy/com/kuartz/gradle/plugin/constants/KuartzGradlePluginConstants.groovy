package com.kuartz.gradle.plugin.constants

/**
 @author Kutay Celebi
 @since 29.09.2019
 */
final class KuartzGradlePluginConstants {

    public static final String GRADLE_EXTENSION_NAME = "kuartzplugin"

    // QueryDsl Constants start
    public static final String DEFAULT_QDSL_SOURCE_DIR = "src/main/java/"
    public static final String QDSL_TASK_GROUP = "kuartzQueryDsl"
    public static final String DEFAULT_QDSL_ENTITY_SUFFIX = "Query"
    public static final String DEFAULT_QDSL_PACKAGE_SUFFIX = ".query"

    public static final String DEFAULT_QDSL_LIBRARY = "com.querydsl:querydsl-apt:4.2.1"
    public static final String JPA_PROCESSOR = "com.querydsl.apt.jpa.JPAAnnotationProcessor"

    // QueryDsl Constants end
}
