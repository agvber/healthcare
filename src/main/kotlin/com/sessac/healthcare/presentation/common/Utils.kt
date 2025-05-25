package com.sessac.healthcare.presentation.common

inline fun loop(action: () -> Unit) {
    while (true) {
        action()
    }
}