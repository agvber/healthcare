package com.sessac.healthcare.presentation.home

import com.sessac.healthcare.data.model.HistoryDataModel
import com.sessac.healthcare.data.model.UserDataModel
import com.sessac.healthcare.presentation.home.controller.HomeController
import com.sessac.healthcare.presentation.home.ui.HomeView


class HomeControllerTest {

    private lateinit var user: UserDataModel
    private lateinit var histories: List<HistoryDataModel>
    private lateinit var controller: HomeController
    private lateinit var view: HomeView

//    @Test
//    fun `홈`(){
//        user = UserDataSourceImpl.getUserById(1)
//        histories = HistoryDataSourceImpl.getUserHistories(user.pk)
//
//        controller = HomeController(user, histories)
//
//        controller.launchHome()
//    }
}