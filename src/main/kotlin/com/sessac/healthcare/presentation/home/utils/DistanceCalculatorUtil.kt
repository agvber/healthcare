package com.sessac.healthcare.presentation.home.utils

import com.sessac.healthcare.data.model.HistoryDataModel
import com.sessac.healthcare.presentation.home.utils.HealthUtil.calculateBMI
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters

object DistanceCalculatorUtil {
    private val today: LocalDate = LocalDate.now()

    // 현재 주 계산
    private fun getCurrentWeekPeriod(): Pair<LocalDate, LocalDate> {
        val weekStart =
            today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)) // today를 기준으로 이전부터 가장 가까운 월요일을 찾음 5-25(일요일)이면, 05-19가 반환됨.
        val weekEnd = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)) // today를 기준으로 이후부터 가장 가까운 일요일을 찾음
        return Pair(weekStart, weekEnd)
    }

    /**
     * 유저의 총 누적 거리 계산
     */
    fun calculateTotalDistance(histories: List<HistoryDataModel>) = histories.sumOf { it.distanceWalked }

    /**
     * 유저의 주간 누적 거리 계싼
     */
    fun calculateWeeklyTotalDistance(histories: List<HistoryDataModel>): Long {
        val (start, end) = getCurrentWeekPeriod()
        return histories.filter {
            val date = it.startDateTime.toLocalDate()
            !date.isBefore(start) && !date.isAfter(end)// start <= date <= end
        }.sumOf { it.distanceWalked }
    }

    /**
     * 유저의 일일 누적 거리 계산
     */
    fun calculateDailyTotalDistance(histories: List<HistoryDataModel>): Long {
        return histories.filter {
            it.startDateTime.toLocalDate() == today
        }.sumOf { it.distanceWalked }
    }

    /**
     * 기본 목표 거리 설정
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


}