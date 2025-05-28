package com.sessac.healthcare.presentation.home.controller

import com.sessac.healthcare.data.model.HistoryDataModel
import com.sessac.healthcare.data.model.UserDataModel
import com.sessac.healthcare.domain.usecase.GetLoggedInUserUseCase
import com.sessac.healthcare.domain.usecase.GetUserHistoriesUseCase
import com.sessac.healthcare.domain.usecase.SaveProgramDataUseCase
import com.sessac.healthcare.presentation.common.ViewController
import com.sessac.healthcare.presentation.common.loop
import com.sessac.healthcare.presentation.home.HomeUIMapper
import com.sessac.healthcare.presentation.home.controller.menu.HomeMenuHandler
import com.sessac.healthcare.presentation.home.controller.menu.HomeMenuListener
import com.sessac.healthcare.presentation.home.model.HomeCalculatedModel
import com.sessac.healthcare.presentation.home.model.HomeUIModel
import com.sessac.healthcare.presentation.home.ui.HomeView
import com.sessac.healthcare.presentation.home.utils.DistanceCalculatorUtil
import com.sessac.healthcare.presentation.home.utils.HealthUtil

class HomeController : ViewController {
    private val menuListener: HomeMenuListener = HomeMenuHandler()
    private val getLoggedInUser = GetLoggedInUserUseCase()
    private val getUserHistories = GetUserHistoriesUseCase()

    private lateinit var user: UserDataModel
    private lateinit var histories: List<HistoryDataModel>
    private lateinit var homeUIModel: HomeUIModel

    override fun run() {
        loop { launchHome() }
    }

    private fun launchHome() {
        user = getLoggedInUser()
        histories = getUserHistories(user.userId)

        homeUIModel = HomeUIMapper.mapToHomeUIModel(user, calculateHomeData())
        HomeView.displayHomeHeader()
        HomeView.displayUserInfo(homeUIModel)
        HomeView.displayDistanceInfo(homeUIModel)

        when (HomeView.displayMenu().trim()) {
            RECORD_NUMBER -> menuListener.onSelectRecord()
            GOAL_NUMBER -> menuListener.onSelectGoal()
            REPORT_NUMBER -> menuListener.onSelectReport()
            USER_INFO_NUMBER -> menuListener.onSelectUserInfo()
            EXIT_NUMBER -> {
                SaveProgramDataUseCase().invoke()
                menuListener.onExit()
            }

            else -> menuListener.onInvalidInput()
        }
    }

    private fun calculateHomeData(): HomeCalculatedModel {
        val bmi = HealthUtil.calculateBMI(user.height, user.weight)
        val defaultGoalDistance = DistanceCalculatorUtil.calculateTotalGoalDistance(user.height, user.weight)
        val userWeeklyTotalDistance = DistanceCalculatorUtil.calculateWeeklyTotalDistance(histories)
        val userDailyTotalDistance = DistanceCalculatorUtil.calculateDailyTotalDistance(histories)
        val userTotalDistance = DistanceCalculatorUtil.calculateTotalDistance(histories)
        val lifeExtension = HealthUtil.calculateLifeExtension(userTotalDistance)

        return HomeCalculatedModel(
            bmi = bmi,
            defaultGoalDistance = defaultGoalDistance,
            userWeeklyTotalDistance = userWeeklyTotalDistance,
            userDailyTotalDistance = userDailyTotalDistance,
            lifeExtension = lifeExtension,
            userTotalDistance = userTotalDistance
        )
    }

    companion object {
        private const val RECORD_NUMBER = "1"
        private const val GOAL_NUMBER = "2"
        private const val REPORT_NUMBER = "3"
        private const val USER_INFO_NUMBER = "4"
        private const val EXIT_NUMBER = "0"


    }
}