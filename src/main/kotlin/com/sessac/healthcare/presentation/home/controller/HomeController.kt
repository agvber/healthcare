package com.sessac.healthcare.presentation.home.controller

import com.sessac.healthcare.data.model.HistoryDataModel
import com.sessac.healthcare.data.model.UserDataModel
import com.sessac.healthcare.presentation.goal.GoalController
import com.sessac.healthcare.presentation.home.HomeUIMapper
import com.sessac.healthcare.presentation.home.model.HomeUIModel
import com.sessac.healthcare.presentation.home.ui.HomeView
import com.sessac.healthcare.presentation.login.LoginController
import com.sessac.healthcare.presentation.onboarding.OnboardingController
import com.sessac.healthcare.presentation.record.RecordController
import com.sessac.healthcare.presentation.report.ReportController
import com.sessac.healthcare.presentation.userprofile.controller.UserProfileController
import kotlin.system.exitProcess

class HomeController(
    private val user: UserDataModel,
    private val histories: List<HistoryDataModel>
//    private val menuListener: HomeMenuListener
) {
    private lateinit var homeUIModel: HomeUIModel

    fun launchHome() {
        homeUIModel = HomeUIMapper.mapToHomeUIModel(user, histories)
        HomeView.displayHomeHeader()
        HomeView.displayUserInfo(homeUIModel)
        HomeView.displayDistanceInfo(homeUIModel)

        when (val menu = HomeView.displayMenu().trim()) { // 1. 온보딩 2. 로그인 3. 기록 4. 내 정보 5. 리포트
            "1" -> OnboardingController().run()
            "2" -> LoginController().run()
            "3" -> RecordController(user).run()
            "4" -> UserProfileController(user).launchUserProfile()
            "5" -> ReportController().run()
            "6" -> GoalController().run()
            "exit" -> exitProcess(0)
            else -> TODO("잘못 입력하셨습니다.")
        }
//
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
}