package com.sessac.healthcare.domain.usecase

import com.sessac.healthcare.data.datasource.GHistoryDataSource
import com.sessac.healthcare.data.datasource.impl.GHistoryDataSourceImpl
import com.sessac.healthcare.domain.entites.ReportEntity

class GetUserTotalCarbonReductionUseCase(
    private val GHistoryDataSource: GHistoryDataSource = GHistoryDataSourceImpl,
    private val reportEntity: ReportEntity = ReportEntity()
) {
    operator fun invoke(): Double {
        val userHistories = GHistoryDataSource.getUserHistories("") // 내 정보 가져오기
        val totalDistanceWalked = userHistories.sumOf { it.distanceWalked }
        return reportEntity.calculateCarbonReduction(totalDistanceWalked)
    }
}