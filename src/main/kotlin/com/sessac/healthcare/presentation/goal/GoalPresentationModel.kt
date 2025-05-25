package com.sessac.healthcare.presentation.goal

import com.sessac.healthcare.presentation.home.model.TreeGrowthStage

/**
 * Goal presentation model
 * @property userName 사용자 이름
 * @property tree 목표 달성에 따른 트리 상태
 * @property remainingBMIDistance BMI 별 남은 거리
 * @property dailyGoalDistance 일단 목표 거리
 * @property weeklyGoalDistance 주간 목표 거리
 * @property totalGoalDistance 총 목표 거리
 */

data class GoalPresentationModel (
    val userName: String,
    val tree: TreeGrowthStage,
    val remainingBMIDistance: Long,
    val dailyGoalDistance: Long,
    val weeklyGoalDistance: Long,
    val totalGoalDistance: Long
)