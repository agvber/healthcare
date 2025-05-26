package com.sessac.healthcare.presentation.home.ui

import com.sessac.healthcare.presentation.home.model.HomeUIModel

object HomeView {

    fun displayHomeHeader() {
        println("\n\n\n======================================")
        println(
            """
            *
           ***
          *****
         *******        건강 기록 프로그램
        *********      (Healthy Life CLI)
       ***********
            |
        """.trimIndent()
        )
        println("======================================")
        println()
    }

    fun displayUserInfo(model: HomeUIModel) {
        println("\t\t\t 사용자 정보 ")
        println("\t\t 사용자 이름  : ${model.nickName}")
        println("\t\t 키         : ${model.height}cm")
        println("\t\t 체중        : ${model.weight}kg")
        println()
    }

    fun displayDistanceInfo(model: HomeUIModel) {
        println("\t\t\t 거리 및 건강 정보 ")
        println("\t\t BMI          : ${model.bmi}")
        println("\t\t 주간 목표 거리 : ${model.userWeeklyGoalDistance} m")
        println("\t\t 주간 누적 거리 : ${model.userWeeklyTotalDistance} m")
        println("\t\t 일일 목표 거리 : ${model.userDailyGoalDistance} m")
        println("\t\t 일일 누적 거리 : ${model.userDailyTotalDistance} m")
        println("\t\t 총 누적 거리   : ${model.userTotalDistance} m")
        println("\t\t 건강을 위한 목표 거리 : ${model.defaultGoalDistance} m")
        println("\t\t 늘어난 수명    : ${model.lifeExtension.first}시간 ${model.lifeExtension.second}분")
        println()
    }

    fun printTreeStatus(model: HomeUIModel) {
//        val tree = when(model.tree) {
//            TreeGrowthStage.FULL_TREE -> model.tree.tree
//
//            TreeGrowthStage.MATURE_TREE -> model.tree.tree
//
//            TreeGrowthStage.SAPLING -> model.tree.tree
//
//            TreeGrowthStage.SPROUT -> model.tree.tree
//        }
//        println(model.tree.tree)
//        println()
    }

    fun testMenu(): String{
        println("======================================")
        println("1. 회원가입 화면")
        println("2. 로그인 화면")
        println("3. 기록 화면")
        println("4. 내 정보")
        println("5. 리포트")
        println("exit. 프로그램 종료")
        println("======================================")
        print("선택 >> ")
        return readln()
    }

    fun displayMenu(): String{
        println("======================================")
        println("1. 기록 화면")
        println("2. 목표 화면")
        println("3. 리포트 화면")
        println("4. 내 정보")
        println("exit. 프로그램 종료")
        println("======================================")
        print("선택 >> ")
        return readln()
    }
}