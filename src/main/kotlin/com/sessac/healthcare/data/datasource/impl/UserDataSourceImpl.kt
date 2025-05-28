package com.sessac.healthcare.data.datasource.impl

import com.sessac.healthcare.data.datasource.UserDataSource
import com.sessac.healthcare.data.model.UserDataModel
import com.sessac.healthcare.data.model.fake.DummyUserModels


object UserDataSourceImpl : UserDataSource {

    private val dummyUsers: MutableList<UserDataModel> = DummyUserModels().get().toMutableList()

    override fun getUsers(): List<UserDataModel> = dummyUsers

    override fun createUser(userDataModel: UserDataModel) {
        dummyUsers.add(userDataModel)
    }

    override fun getUserById(id: String) = dummyUsers.first { it.userId == id }

    override fun updateUser(userDataModel: UserDataModel) {
        dummyUsers[dummyUsers.indexOfFirst {
            it.userId == userDataModel.userId
        }] = userDataModel
    }

    override fun deleteUser(id: String) {
        TODO("Not yet implemented")
    }

    override fun saveProgramData() {
        TODO("Not yet implemented")
    }
}