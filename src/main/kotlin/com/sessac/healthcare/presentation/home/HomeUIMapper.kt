package com.sessac.healthcare.presentation.home

import com.sessac.healthcare.data.model.UserDataModel
import com.sessac.healthcare.presentation.home.model.HomeCalculatedData
import com.sessac.healthcare.presentation.home.model.HomeUIModel

object HomeUIMapper {

    fun mapToHomeUIModel(
        user: UserDataModel,
        calculated: HomeCalculatedData

        ) = HomeUIModel(
        id = user.id,
        nickName = user.nickname,
        bmi = calculated.bmi,
        defaultGoalDistance = calculated.defaultGoalDistance,
        userWeeklyGoalDistance = user.weeklyGoalDistance,
        userWeeklyTotalDistance = calculated.userWeeklyTotalDistance,
        userDailyGoalDistance = user.dailyGoalDistance,
        userDailyTotalDistance = calculated.userDailyTotalDistance,
        userTotalDistance = calculated.userTotalDistance,
        userTotalGoalDistance = user.goalDistance,
        height = user.height,
        weight = user.weight,
        lifeExtension = calculated.lifeExtension
    )

}