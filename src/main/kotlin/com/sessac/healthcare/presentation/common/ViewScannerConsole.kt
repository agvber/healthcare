package com.sessac.healthcare.presentation.common

import java.util.*

object ViewScannerConsole {

    private lateinit var scanner: Scanner

    fun fetchReadLine(): String {
        if (!::scanner.isInitialized) {
            scanner = Scanner(System.`in`)
            return scanner.nextLine()
        }
        return scanner.nextLine()
    }
}