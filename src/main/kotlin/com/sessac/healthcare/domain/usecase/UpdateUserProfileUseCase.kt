package com.sessac.healthcare.domain.usecase

import com.sessac.healthcare.data.datasource.UserDataSource
import com.sessac.healthcare.data.datasource.impl.FileUserDataSource
import com.sessac.healthcare.data.model.UserDataModel
import com.sessac.healthcare.domain.entites.SessionManager

// 유저 정보를 업데이트함.
class UpdateUserProfileUseCase(
    private val userDataSource: UserDataSource = FileUserDataSource.getInstance(),
    private val sessionManager: SessionManager = SessionManager.getInstance()
) {
    operator fun invoke(updatedUser: UserDataModel) {
        userDataSource.updateUser(updatedUser)
        sessionManager.setUser(updatedUser)
    }
}