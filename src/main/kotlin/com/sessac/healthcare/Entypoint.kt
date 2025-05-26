package com.sessac.healthcare

import com.sessac.healthcare.data.datasource.impl.HistoryDataSourceImpl
import com.sessac.healthcare.data.datasource.impl.UserDataSourceImpl
import com.sessac.healthcare.data.model.fake.DummyUserModels
import com.sessac.healthcare.presentation.home.controller.HomeController

fun main() {
    var user = DummyUserModels().get().first()
    val histories = HistoryDataSourceImpl.getUserHistories(user.pk)
    while (true) {
        user = UserDataSourceImpl.getUserById(user.pk)
        HomeController(
            user = user,
            histories = histories
        ).launchHome()
    }
}