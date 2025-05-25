package com.sessac.healthcare.presentation.home.utils

import com.sessac.healthcare.presentation.home.model.TreeGrowthStage

object HealthUtil {

    /**
     * BMI 계산
     *
     * @return 체중 / 키(m)^2
     */
    fun calculateBMI(heightCm: Float, weightKg: Float): Float {
        val heightMeter = heightCm / 100.0
        return (weightKg / (heightMeter * heightMeter)).toFloat()
    }

    /**
     * 누적 거리 비율에 따른 트리
     *
     * @param totalDistance 누적 거리
     * @param defaultDistance 기본 목표 거리
     */
    fun calculateTreeGrowthStage(totalDistance: Long, defaultDistance: Long): TreeGrowthStage {
        val ratio = totalDistance.toDouble() / defaultDistance
        return when {
            ratio >= 1.0 -> TreeGrowthStage.FULL_TREE
            ratio >= 0.6 -> TreeGrowthStage.MATURE_TREE
            ratio >= 0.3 -> TreeGrowthStage.SAPLING
            else -> TreeGrowthStage.SPROUT
        }
    }

    /**
     * 수명 연장 시간 계산
     * 1km 5분 수명 연장
     *
     * @param totalDistance 총 누적 거리 (단위: m)
     * @return Pair<시, 분>
     */
    fun calculateLifeExtension(totalDistance: Long): Pair<Int, Int> {
        val totalMinutes = (totalDistance / 1000) * 5  // 1km = 5분
        val hours = (totalMinutes / 60).toInt()
        val minutes = (totalMinutes % 60).toInt()
        return Pair(hours, minutes)
    }

}