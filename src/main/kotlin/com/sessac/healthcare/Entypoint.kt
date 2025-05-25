package com.sessac.healthcare

import com.sessac.healthcare.data.datasource.impl.HistoryDataSourceImpl
import com.sessac.healthcare.data.model.fake.DummyHistoryModels
import com.sessac.healthcare.data.model.fake.DummyUserModels
import com.sessac.healthcare.presentation.home.controller.HomeController

fun main() {
    val user = DummyUserModels().get().first()
    val histories = HistoryDataSourceImpl.getUserHistories(user.pk)


    while (true) {
        HomeController(
            user = user,
            histories = histories
        ).launchHome()
    }
}