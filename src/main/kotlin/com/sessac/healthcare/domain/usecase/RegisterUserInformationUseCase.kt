package com.sessac.healthcare.domain.usecase

import com.sessac.healthcare.data.ds.UserDataSource
import com.sessac.healthcare.data.ds.impl.UserDataSourceImpl
import com.sessac.healthcare.data.model.NewUserDataModel
import com.sessac.healthcare.domain.SessionManager
import com.sessac.healthcare.domain.UserEntity
import com.sessac.healthcare.domain.exception.IdExistException

class RegisterUserInformationUseCase(
    private val userEntity: UserEntity = UserEntity(),
    private val userDataSource: UserDataSource = UserDataSourceImpl,
    private val sessionManager: SessionManager = SessionManager.getInstance()
) {

    operator fun invoke(
        id: String,
        password: String,
        nickname: String,
        height: Float,
        weight: Float
    ) {
        require(
            value = userEntity.checkId(id) && userEntity.checkPassword(password) &&
                    userEntity.checkNickname(nickname)
        ) { "사용자 정보 유효성 검사" }

        if (isUserIdExist(id)) {
            throw IdExistException()
        }

        val user = NewUserDataModel(
            userId = id,
            password = password,
            nickname = nickname,
            height = height,
            weight = weight,
            goalDistance = 0,
            dailyGoalDistance = 0,
            weeklyGoalDistance = 0
        )
        userDataSource.createUser(newUserDataModel = user)
        sessionManager.setUser(user)
    }

    private fun isUserIdExist(id: String) =
        userDataSource.getUsers().find { it.userId == id } != null
}