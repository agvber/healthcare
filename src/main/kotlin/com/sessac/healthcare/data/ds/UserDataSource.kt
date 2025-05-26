package com.sessac.healthcare.data.ds

import com.sessac.healthcare.data.model.NewUserDataModel

interface UserDataSource {

    fun getUsers(): List<NewUserDataModel>

    fun createUser(newUserDataModel: NewUserDataModel)

    fun getUserById(id: String): NewUserDataModel

    fun updateUser(newUserDataModel: NewUserDataModel)

    fun deleteUser(id: String)
}