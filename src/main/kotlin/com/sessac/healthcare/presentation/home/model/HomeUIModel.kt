package com.sessac.healthcare.presentation.home.model

/**
 * @property defaultGoalDistance BMI로 계산한 기본 목표 거리
 * @property userGoalDistance 사용자가 일일 목표 거리
 * @property userDailyDistance 사용자 일일 누적 거리
 * @property userTotalDistance 총 누적 거리
 * @property tree 트리 상태
 * @property lifeExtension 수명 연장
 */
data class HomeUIModel(
    val id: String,
    var nickName: String,
    var bmi: Float,
    var defaultGoalDistance: Long,
    var userGoalDistance: Long,
    var userDailyDistance: Long,
    var userTotalDistance: Long,
    var height: Float,
    var weight: Float,
    var tree: TreeGrowthStage = TreeGrowthStage.SPROUT,
    var lifeExtension: Pair<Int, Int> = Pair(0,0)
)
