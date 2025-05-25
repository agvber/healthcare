package com.sessac.healthcare.data.datasource

import com.sessac.healthcare.data.model.UserDataModel

interface UserDataSource {

    fun getUsers(): List<UserDataModel>

    fun setUser(userDataModel: UserDataModel)

    fun getUserById(id: String): UserDataModel

    fun setUserGoalDistance(userId: String, newGoalDistance: Long): UserDataModel

    fun setUserWeeklyGoalDistance(userId: String, newWeeklyGoalDistance: Long): UserDataModel

    fun setUserDailyGoalDistance(userId: String, newDailyGoalDistance: Long): UserDataModel
}