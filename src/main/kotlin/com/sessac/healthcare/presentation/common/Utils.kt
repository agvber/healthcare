package com.sessac.healthcare.presentation.common

inline fun loop(
    isContinue: () -> Boolean = { true },
    action: () -> Unit
) {
    while (isContinue()) {
        action()
    }
}