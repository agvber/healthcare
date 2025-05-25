package com.sessac.healthcare.presentation.goal

import com.sessac.healthcare.data.model.HistoryDataModel
import com.sessac.healthcare.data.model.UserDataModel
import com.sessac.healthcare.presentation.home.utils.HealthUtil.calculateTotalGoalDistance
import com.sessac.healthcare.presentation.home.utils.HealthUtil.calculateTreeGrowthStage

class GoalMapper {
    fun dataModelToPresentation(
        user: UserDataModel,
        histories: List<HistoryDataModel>,
    ): GoalPresentationModel {
        val totalDistance = histories.sumOf { it.distanceWalked }
        val remainingBMIDistance = calculateTotalGoalDistance(user.height, user.weight) - totalDistance
        val tree = calculateTreeGrowthStage(totalDistance, user.goalDistance)

        return GoalPresentationModel(
            userName = user.nickname,
            tree = tree,
            remainingBMIDistance = remainingBMIDistance,
            dailyGoalDistance = user.dailyGoalDistance,
            weeklyGoalDistance = user.weeklyGoalDistance,
            totalGoalDistance = user.goalDistance
        )
    }
}