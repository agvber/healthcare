package com.sessac.healthcare.domain.usecase

import com.sessac.healthcare.data.datasource.HistoriesDataSource
import com.sessac.healthcare.data.datasource.impl.FileHistoriesDataSource
import com.sessac.healthcare.data.model.UserDataModel
import com.sessac.healthcare.domain.entites.ReportEntity
import com.sessac.healthcare.domain.entites.SessionManager

class GetUserTotalCarbonReductionUseCase(
    private val historiesDataSource: HistoriesDataSource = FileHistoriesDataSource.getInstance(),
    private val reportEntity: ReportEntity = ReportEntity(),
    private val sessionManager: SessionManager = SessionManager.getInstance()
) {
    operator fun invoke(): Double {
        val user: UserDataModel = sessionManager.getUser()
        val userHistories = historiesDataSource.getUserHistories(user.userId)
        val totalDistanceWalked = userHistories.sumOf { it.distanceWalked }
        return reportEntity.calculateCarbonReduction(totalDistanceWalked)
    }
}