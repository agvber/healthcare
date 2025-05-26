package com.sessac.healthcare

import com.sessac.healthcare.data.model.fake.GDummyHistoryModels
import com.sessac.healthcare.data.model.fake.GDummyUserModels
import com.sessac.healthcare.presentation.home.controller.HomeController

fun main() {
    while (true) {
        HomeController(
            user = GDummyUserModels().get()[0],
            histories = GDummyHistoryModels().get()
        ).launchHome()
    }
}