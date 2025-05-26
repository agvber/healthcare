package com.sessac.healthcare.data.model

data class NewUserDataModel(
    val userId: String,
    val password: String,
    val nickname: String,
    val height: Float,
    val weight: Float,
    val goalDistance: Long,
    val dailyGoalDistance: Long,
    val weeklyGoalDistance: Long,
)