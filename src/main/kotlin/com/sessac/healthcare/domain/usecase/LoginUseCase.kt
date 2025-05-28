package com.sessac.healthcare.domain.usecase

import com.sessac.healthcare.data.datasource.UserDataSource
import com.sessac.healthcare.data.datasource.impl.UserDataSourceImpl
import com.sessac.healthcare.domain.entites.SessionManager
import com.sessac.healthcare.domain.entites.UserEntity
import com.sessac.healthcare.domain.exception.SignupRequiredException

class LoginUseCase(
    private val userEntity: UserEntity = UserEntity(),
    private val userDataSource: UserDataSource = UserDataSourceImpl,
    private val sessionManager: SessionManager = SessionManager.getInstance()
) {

    operator fun invoke(id: String, password: String) {
        require(userEntity.checkId(id) && userEntity.checkPassword(password))
        userDataSource.getUsers()
            .find { it.userId == id && it.password == password }
            ?.also { sessionManager.setUser(it) }
            ?: throw SignupRequiredException()
    }
}