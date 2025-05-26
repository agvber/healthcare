package com.sessac.healthcare.data.utils

import com.sessac.healthcare.common.BuildConfig

object LogUtils {

    @Suppress("KotlinConstantConditions")
    fun printlnDebugMode(message: Any?) {
        if (BuildConfig.IS_DEBUG) {
            println(message)
        }
    }

    @Suppress("KotlinConstantConditions")
    fun printDebugLog(tag: String, message: Any?) {
        if (BuildConfig.IS_DEBUG) {
            println("Tag: $tag, Message: $message")
        }
    }
}