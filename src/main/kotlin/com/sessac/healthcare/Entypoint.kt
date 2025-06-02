package com.sessac.healthcare

import com.sessac.healthcare.data.datasource.impl.FileHistoriesDataSource
import com.sessac.healthcare.data.datasource.impl.FileUserDataSource
import com.sessac.healthcare.presentation.login.LoginController
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        FileUserDataSource.getInstance().init()
        FileHistoriesDataSource.getInstance().init()
    }

    LoginController().run()
}