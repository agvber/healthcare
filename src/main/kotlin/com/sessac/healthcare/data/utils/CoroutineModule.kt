package com.sessac.healthcare.data.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

object CoroutineModule {

    val defaultDispatcher = Dispatchers.Default
    val ioDispatcher = Dispatchers.IO

    val coroutineScope = CoroutineScope(SupervisorJob())
}