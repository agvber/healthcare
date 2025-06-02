package com.sessac.healthcare.data.datasource

import com.sessac.healthcare.data.model.UserDataModel
import kotlinx.coroutines.flow.Flow

interface UserDataSource {

    fun getUsers(): List<UserDataModel>

    fun createUser(userDataModel: UserDataModel)

    fun getUserById(id: String): UserDataModel

    fun updateUser(userDataModel: UserDataModel)

    fun deleteUser(id: String)

    fun saveProgramData(): Flow<Result<Unit>>
}