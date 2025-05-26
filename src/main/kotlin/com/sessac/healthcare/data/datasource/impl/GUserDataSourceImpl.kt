package com.sessac.healthcare.data.datasource.impl

import com.sessac.healthcare.data.datasource.GUserDataSource
import com.sessac.healthcare.data.model.GUserDataModel
import com.sessac.healthcare.data.model.fake.GDummyUserModels

object GUserDataSourceImpl : GUserDataSource {

    private val dummyUsers: MutableList<GUserDataModel> = GDummyUserModels().get().toMutableList()

    override fun getUsers(): List<GUserDataModel> {
        return dummyUsers
    }

    override fun setUser(GUserDataModel: GUserDataModel) {
        dummyUsers.add(GUserDataModel)
    }

    override fun getUserById(id: String): GUserDataModel {
        return dummyUsers.first { it.id == id }
    }

    override fun setUserGoalDistance(userId: String, newGoalDistance: Long): GUserDataModel {
        val user = dummyUsers.find { it.id == userId }
            ?: throw IllegalArgumentException("$userId 유저가 없습니다.")

        user.goalDistance = newGoalDistance
        return user
    }


    override fun setUserWeeklyGoalDistance(userId: String, newWeeklyGoalDistance: Long): GUserDataModel {
        val user = dummyUsers.find { it.id == userId }
            ?: throw IllegalArgumentException("$userId 유저가 없습니다.")

        user.weeklyGoalDistance = newWeeklyGoalDistance
        return user
    }

    override fun setUserDailyGoalDistance(userId: String, newDailyGoalDistance: Long): GUserDataModel {
        val user = dummyUsers.find { it.id == userId }
            ?: throw IllegalArgumentException("$userId 유저가 없습니다.")

        user.dailyGoalDistance = newDailyGoalDistance
        return user
    }

}