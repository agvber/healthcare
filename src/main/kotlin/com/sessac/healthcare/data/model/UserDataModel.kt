package com.sessac.healthcare.data.model


/**
 * User data model
 *
 * @property pk
 * @property nickname
 * @property height
 * @property weight
 * @property goalDistance 총 목표 거리 (m단위)
 * @property id 사용자의 아이디
 * @property password 사용자의 비밀번호
 * @property dailyGoalDistance 하루 목표 거리 (m단위)
 * @property weeklyGoalDistance 주간 목표 거리 (m단위)
 * @constructor Create empty User data model
 */

data class UserDataModel(
    val pk: Long,
    val nickname: String,
    val height: Float,
    val weight: Float,
    val goalDistance: Long,
    val id: String,
    val password: String,
    val dailyGoalDistance: Long,
    val weeklyGoalDistance: Long,
)