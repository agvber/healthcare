package com.sessac.healthcare.presentation.home

import com.sessac.healthcare.data.model.HistoryDataModel
import com.sessac.healthcare.data.model.UserDataModel
import com.sessac.healthcare.presentation.home.model.HomeUIModel
import com.sessac.healthcare.presentation.home.ui.HomeView

class HomeController(
    private val user: UserDataModel,
    private val histories: List<HistoryDataModel>,
) {
    private lateinit var homeUIModel: HomeUIModel
    private var homeView = HomeView()

    fun startHome() {
        while (true) {
            homeUIModel = HomeUIMapper.mapToHomeUIModel(user, histories)
            homeView.displayHomeHeader()
            homeView.displayUserInfo(homeUIModel)
            homeView.displayDistanceInfo(homeUIModel)
            homeView.printTreeStatus(homeUIModel)

            when (val menu = homeView.displayMenu().trim()) {
                "1" -> println("기록 화면") // TODO: 입력 기능 추가 되면 넣음.

                "2" -> println("목표 화면") // TODO: 입력 기능 추가 되면 넣음.

                "3" -> println("내 정보") // TODO: 입력 기능 추가 되면 넣음.

                "exit" -> {
                    println("프로그램을 종료합니다.")
                    return
                }
                else -> println("잘못된 입력입니다. 다시 입력하세요.")
            }
        }
    }
}