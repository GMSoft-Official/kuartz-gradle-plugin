package com.kuartz.util
/**
 @author Kutay Celebi
 @since 6.10.2019
 */
class KuartzFileNameFilter implements FileFilter {

    @Override
    boolean accept(File pathname) {
        return pathname.path.endsWith(".*entity\$")
    }
}
