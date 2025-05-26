package com.sessac.healthcare.presentation.home

import com.sessac.healthcare.data.model.GHistoryDataModel
import com.sessac.healthcare.data.model.GUserDataModel
import com.sessac.healthcare.presentation.home.model.HomeUIModel
import com.sessac.healthcare.presentation.home.utils.HealthUtil.calculateBMI
import com.sessac.healthcare.presentation.home.utils.HealthUtil.calculateLifeExtension
import com.sessac.healthcare.presentation.home.utils.HealthUtil.calculateTotalGoalDistance
import com.sessac.healthcare.presentation.home.utils.HealthUtil.calculateTreeGrowthStage

object HomeUIMapper {

    fun mapToHomeUIModel(
        user: GUserDataModel,
        histories: List<GHistoryDataModel>,
    ): HomeUIModel {
        val totalDistance = histories.sumOf { it.distanceWalked }
        val bmi = calculateBMI(user.height, user.weight)
        val defaultDistance = calculateTotalGoalDistance(user.height, user.weight)
        val tree = calculateTreeGrowthStage(totalDistance, user.goalDistance)
        val lifeExtension = calculateLifeExtension(totalDistance)

        return HomeUIModel(
            id = user.id,
            nickName = user.nickname,
            bmi = bmi,
            defaultGoalDistance = defaultDistance,
            userGoalDistance = user.goalDistance,
            userDailyDistance = 0,
            userTotalDistance = totalDistance,
            height = user.height,
            weight = user.weight,
            tree = tree,
            lifeExtension = lifeExtension
        )
    }

    /**
     * @param csvUser 유저 파일
     * @param csvHistories 기록 파일
     */
    fun mapToHomeUIModel(csvUser: String, csvHistories: List<String>): HomeUIModel {
        // 유저 파일 -> id, name, 키, 몸무게, 목표 거리
        // 기록 파일 -> id, uid, 시작날짜, 끝날짜, 기록, 거리

        val userFields = csvUser.split(",").map { it.trim() }
        require(userFields.size == 5) { "유저 필드 정보가 잘못 되었습니다." }

        val userId = userFields[0]
        val nickname = userFields[1]
        val height = userFields[2].toFloat()
        val weight = userFields[3].toFloat()
        val goalDistance = userFields[4].toLong()

        val totalDistance = csvHistories
            .map { it.split(",").map(String::trim) }
            .filter { it[1] == userId }
            .sumOf { it[5].toLong() }

        val bmi = calculateBMI(height, weight)
        val defaultGoalDistance = calculateTotalGoalDistance(height, weight)
        val tree = calculateTreeGrowthStage(totalDistance, goalDistance)
        val lifeExtension = calculateLifeExtension(totalDistance)

        return HomeUIModel(
            id = userId,
            nickName = nickname,
            bmi = bmi,
            defaultGoalDistance = defaultGoalDistance,
            userGoalDistance = goalDistance,
            userDailyDistance = 0,
            userTotalDistance = totalDistance,
            height = height,
            weight = weight,
            tree = tree,
            lifeExtension = lifeExtension
        )
    }
}