package com.sessac.healthcare.presentation.home.model

/**
 * @property defaultGoalDistance bmi로 계산한 기본 목표 거리
 * @property userGoalDistance 사용자가 일일 목표 거리
 * @property userDailyDistance 사용자 일일 누적 거리
 * @property userTotalDistance 총 누적 거리
 * @property tree 트리 상태: 🌱🌿🌳 (기본값 🌱)
 */
data class HomeUIModel(
    val id: Long,
    var nickName: String,
    var bmi: Float,
    var defaultGoalDistance: Long,
    var userGoalDistance: Long,
    var userDailyDistance: Long,
    var userTotalDistance: Long,
    var height: Int,
    var weight: Int,
    var tree: TreeGrowthStage = TreeGrowthStage.SPROUT
)
