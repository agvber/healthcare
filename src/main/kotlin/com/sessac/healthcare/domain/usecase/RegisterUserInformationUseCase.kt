package com.sessac.healthcare.domain.usecase

import com.sessac.healthcare.data.datasource.UserDataSource
import com.sessac.healthcare.data.datasource.impl.FileUserDataSource
import com.sessac.healthcare.data.model.UserDataModel
import com.sessac.healthcare.domain.entites.SessionManager
import com.sessac.healthcare.domain.entites.UserEntity
import com.sessac.healthcare.domain.exception.IdExistException

class RegisterUserInformationUseCase(
    private val userEntity: UserEntity = UserEntity(),
    private val userDataSource: UserDataSource = FileUserDataSource.getInstance(),
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

        val user = UserDataModel(
            userId = id,
            password = password,
            nickname = nickname,
            height = height,
            weight = weight,
            goalDistance = 0,
            dailyGoalDistance = 0,
            weeklyGoalDistance = 0
        )
        userDataSource.createUser(userDataModel = user)
        sessionManager.setUser(user)
    }

    private fun isUserIdExist(id: String) =
        userDataSource.getUsers().find { it.userId == id } != null
}