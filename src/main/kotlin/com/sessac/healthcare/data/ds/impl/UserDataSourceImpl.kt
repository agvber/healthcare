package com.sessac.healthcare.data.ds.impl

import com.sessac.healthcare.data.ds.UserDataSource
import com.sessac.healthcare.data.model.NewUserDataModel

object UserDataSourceImpl : UserDataSource {


    override fun getUsers(): List<NewUserDataModel> {
        return dummyUsers
    }

    override fun createUser(newUserDataModel: NewUserDataModel) {
        dummyUsers.add(newUserDataModel)
    }

    override fun getUserById(id: String): NewUserDataModel {
        TODO("Not yet implemented")
    }

    override fun updateUser(newUserDataModel: NewUserDataModel) {
        TODO("Not yet implemented")
    }

    override fun deleteUser(id: String) {
        TODO("Not yet implemented")
    }

    val dummyUsers = mutableListOf(
        NewUserDataModel("user1", "pass123", "Walker1", 175.5f, 70.0f, 100000L, 5000L, 35000L),
        NewUserDataModel("user2", "qwerty", "Jogger2", 160.2f, 55.0f, 80000L, 4000L, 28000L),
        NewUserDataModel("user3", "abc123", "Sprinter3", 180.0f, 80.0f, 120000L, 6000L, 42000L),
        NewUserDataModel("user4", "password", "Runner4", 165.3f, 62.5f, 90000L, 4500L, 31500L),
        NewUserDataModel("user5", "letmein", "Stepper5", 170.0f, 68.0f, 70000L, 3500L, 24500L)
    )

}