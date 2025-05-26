package com.sessac.healthcare.data.ds.impl

import com.sessac.healthcare.data.ds.UserDataSource
import com.sessac.healthcare.data.model.NewUserDataModel
import com.sessac.healthcare.data.model.fake.DummyUserModels


object UserDataSourceImpl : UserDataSource {

    private val dummyUsers: MutableList<NewUserDataModel> = DummyUserModels().get().toMutableList()

    override fun getUsers(): List<NewUserDataModel> = dummyUsers

    override fun createUser(newUserDataModel: NewUserDataModel) {
        dummyUsers.add(newUserDataModel)
    }

    override fun getUserById(id: String) = dummyUsers.first { it.userId == id }

    override fun updateUser(newUserDataModel: NewUserDataModel) {
        dummyUsers[dummyUsers.indexOfFirst {
            it.userId == newUserDataModel.userId
        }] = newUserDataModel
    }

    override fun deleteUser(id: String) {
        TODO("Not yet implemented")
    }
}