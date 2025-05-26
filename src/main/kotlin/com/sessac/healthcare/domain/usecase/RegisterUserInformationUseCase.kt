package com.sessac.healthcare.domain.usecase

import com.sessac.healthcare.data.datasource.UserDataSource
import com.sessac.healthcare.data.datasource.impl.UserDataSourceImpl
import com.sessac.healthcare.data.model.UserDataModel
import com.sessac.healthcare.domain.UserEntity
import kotlin.random.Random

class RegisterUserInformationUseCase(
    private val userEntity: UserEntity = UserEntity(),
    private val userDataSource: UserDataSource = UserDataSourceImpl
) {

    operator fun invoke(
        id: String,
        password: String,
        nickname: String,
        height: Float,
        weight: Float
    ) {
        require(
            userEntity.checkId(id) && userEntity.checkPassword(password) &&
                    userEntity.checkNickname(nickname)
        )

//        val userDataModel = UserDataModel(
//            id = Random.nextLong(10000, 9999999),
//            nickname = nickname,
//            height = userEntity.removeSecondFloatPlace(height).toInt(),
//            weight = userEntity.removeSecondFloatPlace(weight).toInt(),
//            goalDistance = 1000
//        )

//        userDataSource.setUser(userDataModel)
    }
}