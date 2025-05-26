package com.sessac.healthcare.presentation.home

import com.sessac.healthcare.data.datasource.impl.GHistoryDataSourceImpl
import com.sessac.healthcare.data.datasource.impl.GUserDataSourceImpl
import com.sessac.healthcare.data.model.GHistoryDataModel
import com.sessac.healthcare.data.model.GUserDataModel
import com.sessac.healthcare.presentation.home.controller.HomeController
import com.sessac.healthcare.presentation.home.ui.HomeView
import org.junit.jupiter.api.Test


class HomeControllerTest {

    private lateinit var user: GUserDataModel
    private lateinit var histories: List<GHistoryDataModel>
    private lateinit var controller: HomeController
    private lateinit var view: HomeView

    @Test
    fun `홈`(){
        user = GUserDataSourceImpl.getUserById("1")
        histories = GHistoryDataSourceImpl.getUserHistories(user.id)

        controller = HomeController(user, histories)

        controller.launchHome()
    }
}