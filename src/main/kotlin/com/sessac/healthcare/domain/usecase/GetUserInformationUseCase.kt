package com.sessac.healthcare.domain.usecase

import com.sessac.healthcare.data.datasource.GUserDataSource
import com.sessac.healthcare.data.datasource.impl.GUserDataSourceImpl
import com.sessac.healthcare.domain.entites.ReportEntity
import com.sessac.healthcare.domain.model.UserDomainModel

class GetUserInformationUseCase(
    private val GUserDataSource: GUserDataSource = GUserDataSourceImpl,
    private val reportEntity: ReportEntity = ReportEntity()
) {
    operator fun invoke(): UserDomainModel {
        val userDataModel = GUserDataSource.getUserById("0")
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