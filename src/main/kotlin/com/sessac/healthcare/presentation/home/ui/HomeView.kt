package com.sessac.healthcare.presentation.home.ui

import com.sessac.healthcare.presentation.home.model.HomeUIModel
import com.sessac.healthcare.presentation.home.model.TreeGrowthStage

class HomeView {

    fun displayHomeHeader() {
        println("======================================")
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
    }

    fun displayUserInfo(model: HomeUIModel) {
        println()
        println("[ 사용자 이름: ${model.nickName} ]")
        println("[ BMI: ${model.bmi} ]")
    }

    fun displayDistanceInfo(model: HomeUIModel) {
        println("[ 일일 목표 거리: ${model.userGoalDistance}m ]")
        println("[ 일일 누적 거리: ${model.userDailyDistance}m ] ")
        println("[ 총 누적 거리: ${model.userTotalDistance}m ] ")
        println("[ 건강을 위한 목표 거리: ${model.defaultGoalDistance}m ]")
    }

    fun printTreeStatus(model: HomeUIModel) {
        val tree = when(model.tree) {
            TreeGrowthStage.FULL_TREE -> """
            *
           ***
          *****
         *******
        *********
       ***********
            |
        """.trimIndent()

            TreeGrowthStage.MATURE_TREE -> """
           *
          ***
         *****
        *******
           |
        """.trimIndent()

            TreeGrowthStage.SAPLING -> """
          *
         ***
          |
        """.trimIndent()

            TreeGrowthStage.SPROUT -> """
           *
           |
        """.trimIndent()
        }
        println(tree)
        println()
    }

    fun displayMenu(): String{
        println("=====================")
        println("1. 기록 추가")
        println("2. 기록 확인")
        println("3. 기록 수정")
        println("4. 기록 삭제")
        println("5. 내 정보")
        println("exit. 프로그램 종료")
        println("=====================\n")
        print("선택 >> ")
        return readln()
    }
}