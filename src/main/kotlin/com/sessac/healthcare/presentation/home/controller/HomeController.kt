package com.sessac.healthcare.presentation.home.controller

import com.sessac.healthcare.data.datasource.impl.GHistoryDataSourceImpl
import com.sessac.healthcare.data.ds.HistoriesDataSource
import com.sessac.healthcare.data.ds.impl.HistoriesDataSourceImpl
import com.sessac.healthcare.data.model.NewHistoryDataModel
import com.sessac.healthcare.data.model.NewUserDataModel
import com.sessac.healthcare.domain.SessionManager
import com.sessac.healthcare.presentation.common.ViewController
import com.sessac.healthcare.presentation.common.loop
import com.sessac.healthcare.presentation.goal.GoalController
import com.sessac.healthcare.presentation.home.HomeUIMapper
import com.sessac.healthcare.presentation.home.model.HomeCalculatedModel
import com.sessac.healthcare.presentation.home.model.HomeUIModel
import com.sessac.healthcare.presentation.home.ui.HomeView
import com.sessac.healthcare.presentation.home.utils.DistanceCalculatorUtil
import com.sessac.healthcare.presentation.home.utils.HealthUtil
import com.sessac.healthcare.presentation.login.LoginController
import com.sessac.healthcare.presentation.onboarding.OnboardingController
import com.sessac.healthcare.presentation.record.RecordController
import com.sessac.healthcare.presentation.report.ReportController
import com.sessac.healthcare.presentation.userprofile.controller.UserProfileController
import kotlin.system.exitProcess

class HomeController(
//    private val menuListener: HomeMenuListener
) : ViewController {

    private val sessionManager: SessionManager = SessionManager.getInstance()
    private val user = sessionManager.getUser()
    private val histories: List<NewHistoryDataModel> = HistoriesDataSourceImpl.getUserHistories(user.userId)

    private lateinit var homeUIModel: HomeUIModel

    override fun run() {
        loop { launchHome() }
    }

    private fun launchHome() {

        homeUIModel = HomeUIMapper.mapToHomeUIModel(user, calculateHomeData())
        HomeView.displayHomeHeader()
        HomeView.displayUserInfo(homeUIModel)
        HomeView.displayDistanceInfo(homeUIModel)

        when (val menu = HomeView.displayMenu().trim()) {
//            "1" -> RecordController(user, GHistoryDataSourceImpl).run()
//            "2" -> GoalController().run()
            "3" -> ReportController().run()
            "4" -> UserProfileController(user).run()
            "5" -> ReportController().run()
            "exit" -> exitProcess(0)
            else -> println("메뉴 선택을 제대로 입력하세요.")
        }

//        when (val menu = HomeView.displayMenu().trim()) {
//            "1" -> menuListener.onSelectRecord()
//            "2" -> menuListener.onSelectGoal()
//            "3" -> menuListener.onSelectUserInfo()
//            "exit" -> {
//                menuListener.onExit()
//                return
//            }
//            else -> menuListener.onInvalidInput()
//        }
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
}