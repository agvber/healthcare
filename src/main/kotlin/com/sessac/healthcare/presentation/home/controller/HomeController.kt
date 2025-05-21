package com.sessac.healthcare.presentation.home.controller

import com.sessac.healthcare.data.model.HistoryDataModel
import com.sessac.healthcare.data.model.UserDataModel
import com.sessac.healthcare.presentation.home.HomeUIMapper
import com.sessac.healthcare.presentation.home.model.HomeUIModel
import com.sessac.healthcare.presentation.home.ui.HomeView

class HomeController(
    private val user: UserDataModel,
    private val histories: List<HistoryDataModel>,
    private val menuListener: HomeMenuListener
) {
    private lateinit var homeUIModel: HomeUIModel

    fun launchHome() {
        homeUIModel = HomeUIMapper.mapToHomeUIModel(user, histories)
        HomeView.displayHomeHeader()
        HomeView.displayUserInfo(homeUIModel)
        HomeView.displayDistanceInfo(homeUIModel)

        when (val menu = HomeView.displayMenu().trim()) {
            "1" -> menuListener.onSelectRecord()
            "2" -> menuListener.onSelectGoal()
            "3" -> menuListener.onSelectUserInfo()
            "exit" -> {
                menuListener.onExit()
                return
            }
            else -> menuListener.onInvalidInput()
        }
    }
}