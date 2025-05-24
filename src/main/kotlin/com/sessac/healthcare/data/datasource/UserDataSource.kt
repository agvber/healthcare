package com.sessac.healthcare.data.datasource

import com.sessac.healthcare.data.model.UserDataModel

interface UserDataSource {

    fun getUsers(): List<UserDataModel>

    fun setUser(userDataModel: UserDataModel)

    fun getUserById(id: String): UserDataModel
}