package com.sessac.healthcare.presentation.home.ui

import com.sessac.healthcare.presentation.home.model.HomeUIModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object HomeView {

    fun displayHomeHeader() {
        println("\n\n\n\n\n======================================")
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
        println("\t\t 키         : %.1fcm".format(model.height))
        println("\t\t 체중        : %.1fkg".format(model.weight))
        println()
    }

    fun displayDistanceInfo(model: HomeUIModel) {
        println("\t\t\t 거리 및 건강 정보 ")
        println("\t\t BMI          : %.2f".format(model.bmi))
        println("\t\t 주간 목표 거리 : ${model.userWeeklyGoalDistance} m")
        println("\t\t 주간 누적 거리 : ${model.userWeeklyTotalDistance} m")
        println("\t\t 일일 목표 거리 : ${model.userDailyGoalDistance} m")
        println("\t\t 일일 누적 거리 : ${model.userDailyTotalDistance} m")
        println("\t\t 총 누적 거리   : ${model.userTotalDistance} m")
        println("\t\t 총 목표 거리   : ${model.userTotalGoalDistance}")
        println("\t\t 건강을 위한 목표 거리 : ${model.defaultGoalDistance} m")
        println("\t\t 늘어난 수명    : ${model.lifeExtension.first}시간 ${model.lifeExtension.second}분")

        val today = LocalDate.now()
        val format = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 (E)")
        val formatDate = today.format(format)
        println("\n오늘 날짜: $formatDate\n")
    }

    fun displayMenu(): String {
        println("======================================")
        println("1. 기록 화면")
        println("2. 목표 화면")
        println("3. 리포트 화면")
        println("4. 내 정보")
        println("0. 프로그램 종료")
        println("======================================")
        print("선택 >> ")
        return readln()
    }
}