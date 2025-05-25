package com.sessac.healthcare

import com.sessac.healthcare.data.model.fake.DummyHistoryModels
import com.sessac.healthcare.data.model.fake.DummyUserModels
import com.sessac.healthcare.presentation.home.controller.HomeController

fun main() {
    while (true) {
        HomeController(
            user = DummyUserModels().get()[0],
            histories = DummyHistoryModels().get()
        ).launchHome()
    }
}