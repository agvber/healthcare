package com.sessac.healthcare.domain.usecase

import com.sessac.healthcare.domain.entites.SessionManager
import com.sessac.healthcare.domain.entites.ReportEntity
import com.sessac.healthcare.domain.model.UserDomainModel

class GetUserInformationUseCase(
    private val reportEntity: ReportEntity = ReportEntity(),
    private val sessionManager: SessionManager = SessionManager.getInstance()
) {
    operator fun invoke(): UserDomainModel {
        val userDataModel = sessionManager.getUser()
        val weight: Float = userDataModel.weight
        val height: Float = userDataModel.height

        return UserDomainModel(
            nickname = userDataModel.nickname,
            weight = weight,
            height = height,
            bmi = reportEntity.calculateBMI(weight, height)
        )
    }
}