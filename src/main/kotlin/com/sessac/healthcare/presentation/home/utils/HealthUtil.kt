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
     * 기본 목표 거리 설정
     * bmi 계산 없이 바로 사용 가능
     * @return 저체중: 100km 정상: 150km 과체중: 200km 비만: 250km
     */
    fun calculateTotalGoalDistance(heightCm: Float, weightKg: Float): Long {
        val bmi = calculateBMI(heightCm, weightKg)

        return when {
            bmi < 18.5 -> 100_000L  // 100 km
            bmi < 25.0 -> 150_000L  // 150 km
            bmi < 30.0 -> 200_000L  // 200 km
            else -> 250_000L        // 250 km 이상
        }
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