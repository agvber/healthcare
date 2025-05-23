package com.sessac.healthcare.domain.entites

class ReportEntity {

    /**
     * 걷기를 통해 탄소 감소량을 측적하는 함수
     *
     * @param distanceWalked 걸은 거리 단위 : m
     * @return
     */

    fun calculateCarbonReduction(distanceWalked: Long): Double {
        return (distanceWalked / 1000) * 0.21
    }

    /**
     * BMI를 계산하는 함수
     *
     * @param weight 체중 (KG)
     * @param height [신장(m)]²
     * @return
     */

    fun calculateBMI(
        weight: Float,
        height: Float
    ): Float {
        return String.format("%.6f", weight / (height * height)).toFloat() * 10000
    }
}