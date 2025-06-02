package com.sessac.healthcare.presentation.home.utils

import com.sessac.healthcare.data.model.HistoryDataModel
import com.sessac.healthcare.data.model.UserDataModel
import com.sessac.healthcare.presentation.home.model.HomeCalculatedModel

object HomeUtil {
    const val RECORD_NUMBER = "1"
    const val GOAL_NUMBER = "2"
    const val REPORT_NUMBER = "3"
    const val USER_INFO_NUMBER = "4"
    const val EXIT_NUMBER = "0"

    fun calculateHomeData(user: UserDataModel, histories: List<HistoryDataModel>): HomeCalculatedModel {
        return DistanceCalculatorUtil.calculateTotalDistance(histories).let { userTotalDistance ->
            HomeCalculatedModel(
                bmi = HealthUtil.calculateBMI(user.height, user.weight),
                defaultGoalDistance = DistanceCalculatorUtil.calculateTotalGoalDistance(user.height, user.weight),
                userWeeklyTotalDistance = DistanceCalculatorUtil.calculateWeeklyTotalDistance(histories),
                userDailyTotalDistance = DistanceCalculatorUtil.calculateDailyTotalDistance(histories),
                userTotalDistance = userTotalDistance,
                lifeExtension = HealthUtil.calculateLifeExtension(userTotalDistance)
            )
        }
    }
}