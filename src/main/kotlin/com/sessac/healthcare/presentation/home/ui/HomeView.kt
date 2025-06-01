package com.sessac.healthcare.presentation.home.ui

import com.sessac.healthcare.presentation.home.model.HomeUIModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import com.sessac.healthcare.presentation.home.ui.HomeStringResource as Res

object HomeView {

    fun displayHomeHeader() {
        println("\n\n\n${Res.HEADER_LINE}")
        println(Res.HEADER_ASCII_ART.trimIndent())
        println(Res.HEADER_LINE)
        println()
    }


    fun displayUserInfo(model: HomeUIModel) {
        println("\t\t\t ${Res.USER_INFO_TITLE} ")
        println("\t\t ${Res.USER_NAME_LABEL} : ${model.nickName}")
        println("\t\t ${Res.USER_HEIGHT_LABEL} : %.1f${Res.CM_UNIT}".format(model.height))
        println("\t\t ${Res.USER_WEIGHT_LABEL} : %.1f${Res.KG_UNIT}".format(model.weight))
        println()
    }

    fun displayDistanceInfo(model: HomeUIModel) {
        println("\t\t\t ${Res.DISTANCE_INFO_TITLE} ")
        println("\t\t ${Res.BMI_LABEL}: %.2f".format(model.bmi))
        println("\t\t ${Res.WEEKLY_GOAL_LABEL} : ${model.userWeeklyGoalDistance} ${Res.M_UNIT}")
        println("\t\t ${Res.WEEKLY_TOTAL_LABEL} : ${model.userWeeklyTotalDistance} ${Res.M_UNIT}")
        println("\t\t ${Res.DAILY_GOAL_LABEL} : ${model.userDailyGoalDistance} ${Res.M_UNIT}")
        println("\t\t ${Res.DAILY_TOTAL_LABEL} : ${model.userDailyTotalDistance} ${Res.M_UNIT}")
        println("\t\t ${Res.TOTAL_GOAL_LABEL}  : ${model.userTotalGoalDistance} ${Res.M_UNIT}")
        println("\t\t ${Res.TOTAL_DISTANCE_LABEL}  : ${model.userTotalDistance} ${Res.M_UNIT}")
        println("\t\t ${Res.DEFAULT_GOAL_LABEL} : ${model.defaultGoalDistance} ${Res.M_UNIT}")
        println("\t\t ${Res.LIFE_EXTENSION_LABEL} : ${model.lifeExtension.first}${Res.HOUR_UNIT} ${model.lifeExtension.second}${Res.MINUTE_UNIT}")

        val today = LocalDate.now()
        val format = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 (E)")
        val formattedDate = today.format(format)
        println("\n${Res.TODAY_LABEL}: $formattedDate\n")
    }

    fun displayMenu(): String {
        println(Res.HEADER_LINE)
        println(Res.MENU_RECORD)
        println(Res.MENU_GOAL)
        println(Res.MENU_REPORT)
        println(Res.MENU_USER_INFO)
        println(Res.MENU_EXIT)
        println(Res.HEADER_LINE)
        print(Res.MENU_PROMPT)
        return readln()
    }
}