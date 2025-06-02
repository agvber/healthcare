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
import com.sessac.healthcare.presentation.home.model.HomeUIModel
import com.sessac.healthcare.presentation.home.ui.HomeView
import com.sessac.healthcare.presentation.home.utils.DistanceCalculatorUtil
import com.sessac.healthcare.presentation.home.utils.HealthUtil
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import com.sessac.healthcare.presentation.home.utils.HomeUtil.EXIT_NUMBER
import com.sessac.healthcare.presentation.home.utils.HomeUtil.GOAL_NUMBER
import com.sessac.healthcare.presentation.home.utils.HomeUtil.RECORD_NUMBER
import com.sessac.healthcare.presentation.home.utils.HomeUtil.REPORT_NUMBER
import com.sessac.healthcare.presentation.home.utils.HomeUtil.USER_INFO_NUMBER
import com.sessac.healthcare.presentation.home.utils.HomeUtil.calculateHomeData

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

        homeUIModel = HomeUIMapper.mapToHomeUIModel(user, calculateHomeData(user, histories))

        HomeView.run {
            displayHomeHeader()
            displayUserInfo(homeUIModel)
            displayDistanceInfo(homeUIModel)
        } // with은 다른 표준 함수랑 일관성이 없기 때문에 run을 사용

        when (HomeView.displayMenu().trim()) {
            RECORD_NUMBER -> menuListener.onSelectRecord()
            GOAL_NUMBER -> menuListener.onSelectGoal()
            REPORT_NUMBER -> menuListener.onSelectReport()
            USER_INFO_NUMBER -> menuListener.onSelectUserInfo()
            EXIT_NUMBER -> {
                runBlocking { SaveProgramDataUseCase().invoke().first() }
                    .onFailure {
                        // 사용자에거 오류 표시
                    }
                menuListener.onExit()
            }

            else -> menuListener.onInvalidInput()
        }
    }
}