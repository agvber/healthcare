package com.sessac.healthcare.common.utils

import com.sessac.healthcare.common.BuildConfig

@Suppress("KotlinConstantConditions")
fun Throwable.printStackTraceWithDebugMode() {
    if (BuildConfig.IS_DEBUG) {
        printStackTrace()
    }
}