package com.sessac.healthcare.data.datasource

import com.sessac.healthcare.data.model.GUserDataModel

interface GUserDataSource {

    fun getUsers(): List<GUserDataModel>

    fun setUser(GUserDataModel: GUserDataModel)

    fun getUserById(id: String): GUserDataModel

    fun setUserGoalDistance(userId: String, newGoalDistance: Long): GUserDataModel

    fun setUserWeeklyGoalDistance(userId: String, newWeeklyGoalDistance: Long): GUserDataModel

    fun setUserDailyGoalDistance(userId: String, newDailyGoalDistance: Long): GUserDataModel
}