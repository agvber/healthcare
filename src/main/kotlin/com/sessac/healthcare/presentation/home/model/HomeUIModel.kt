package com.sessac.healthcare.presentation.home.model

/**
 * @property defaultGoalDistance BMI로 계산한 기본 목표 거리
 * @property userWeeklyGoalDistance 사용자가 입력한 주간 목표 거리
 * @property userWeeklyTotalDistance 사용자 주간 누적 거리
 * @property userDailyGoalDistance 사용자가 입력한 일일 목표 거리
 * @property userDailyTotalDistance 사용자 일일 누적 거리
 * @property userTotalDistance 사용자가 입력한 총 목표 거리
 * @property userTotalDistance 총 누적 거리
 * @property lifeExtension 수명 연장
 */
data class HomeUIModel(
    val id: String,
    var nickName: String,
    var bmi: Float,
    var defaultGoalDistance: Long,
    var userWeeklyGoalDistance: Long,
    var userWeeklyTotalDistance: Long,
    var userDailyGoalDistance: Long,
    var userDailyTotalDistance: Long,
    var userTotalGoalDistance: Long,
    var userTotalDistance: Long,
    var height: Float,
    var weight: Float,
    var lifeExtension: Pair<Int, Int> = Pair(0,0)
)
