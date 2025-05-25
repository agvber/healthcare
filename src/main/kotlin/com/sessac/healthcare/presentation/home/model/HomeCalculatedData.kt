package com.sessac.healthcare.presentation.home.model

data class HomeCalculatedData(
    var bmi: Float,
    var defaultGoalDistance: Long,
    var userWeeklyTotalDistance: Long,
    var userDailyTotalDistance: Long,
    var userTotalDistance: Long,
    var lifeExtension: Pair<Int, Int> = Pair(0,0)
)
