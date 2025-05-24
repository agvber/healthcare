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
}