package com.sessac.healthcare.domain.usecase

import com.sessac.healthcare.data.datasource.UserDataSource
import com.sessac.healthcare.data.datasource.impl.UserDataSourceImpl
import com.sessac.healthcare.domain.entites.ReportEntity
import com.sessac.healthcare.domain.model.UserDomainModel

class GetUserInformationUseCase(
    private val userDataSource: UserDataSource = UserDataSourceImpl,
    private val reportEntity: ReportEntity = ReportEntity()
) {
    operator fun invoke(): UserDomainModel {
        val userDataModel = userDataSource.getUserById(0)
        val weight = userDataModel.weight.toFloat()
        val height = userDataModel.height.toFloat()

        return UserDomainModel(
            nickname = userDataModel.nickname,
            weight = weight,
            height = height,
            bmi = reportEntity.calculateBMI(weight, height)
        )
    }
}