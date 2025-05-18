package com.sessac.healthcare.presentation.home

import com.sessac.healthcare.data.model.HistoryDataModel
import com.sessac.healthcare.data.model.UserDataModel
import com.sessac.healthcare.presentation.home.model.HomeUIModel
import com.sessac.healthcare.presentation.home.ui.HomeView

class HomeController(
    private val user: UserDataModel,
    private val histories: List<HistoryDataModel>
) {
    private lateinit var homeUIModel: HomeUIModel
    private var homeView = HomeView()

    fun startHome(){
        homeUIModel = HomeUIMapper.mapToHomeUIModel(user, histories)

        while(true) {
            homeView.displayHomeHeader()
            homeView.displayUserInfo(homeUIModel)
            homeView.displayDistanceInfo(homeUIModel)
            homeView.printTreeStatus(homeUIModel)

            when(homeView.displayMenu().trim()) {
                "1" -> {
                    println("기록 추가")
                    // TODO: 입력 기능 추가 되면 넣음.
                }
                "2" -> {
                    println("기록 확인")
                    // TODO: 입력 기능 추가 되면 넣음.
                }
                "3" -> {
                    println("기록 수정")
                    // TODO: 입력 기능 추가 되면 넣음.
                }
                "4" -> {
                    println("기록 삭제")
                    // TODO: 입력 기능 추가 되면 넣음.
                }
                "5" -> {
                    println("내 정보")
                    // TODO: 입력 기능 추가 되면 넣음.
                }
                "exit" -> {
                    println("프로그램을 종료합니다.")
                    return
                }
                else -> println("잘못된 입력입니다. 다시 입력하세요.")
            }
        }
    }
}