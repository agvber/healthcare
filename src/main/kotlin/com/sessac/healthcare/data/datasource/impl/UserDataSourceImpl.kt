package com.sessac.healthcare.data.datasource.impl

import com.sessac.healthcare.data.datasource.UserDataSource
import com.sessac.healthcare.data.model.UserDataModel
import com.sessac.healthcare.data.model.fake.DummyUserModels

object UserDataSourceImpl : UserDataSource {

    private val dummyUsers: MutableList<UserDataModel> = DummyUserModels().get().toMutableList()

    override fun getUsers(): List<UserDataModel> {
        return dummyUsers
    }

    override fun setUser(userDataModel: UserDataModel) {
        dummyUsers.add(userDataModel)
    }

    override fun getUserById(id: String): UserDataModel {
        return dummyUsers.first { it.id == id }
    }

    override fun setUserGoalDistance(userId: String, newGoalDistance: Long): UserDataModel {
        val user = dummyUsers.find { it.id == userId }
            ?: throw IllegalArgumentException("$userId 유저가 없습니다.")

        user.goalDistance = newGoalDistance
        return user
    }


    override fun setUserWeeklyGoalDistance(userId: String, newWeeklyGoalDistance: Long): UserDataModel {
        val user = dummyUsers.find { it.id == userId }
            ?: throw IllegalArgumentException("$userId 유저가 없습니다.")

        user.weeklyGoalDistance = newWeeklyGoalDistance
        return user
    }

    override fun setUserDailyGoalDistance(userId: String, newDailyGoalDistance: Long): UserDataModel {
        val user = dummyUsers.find { it.id == userId }
            ?: throw IllegalArgumentException("$userId 유저가 없습니다.")

        user.dailyGoalDistance = newDailyGoalDistance
        return user
    }

}