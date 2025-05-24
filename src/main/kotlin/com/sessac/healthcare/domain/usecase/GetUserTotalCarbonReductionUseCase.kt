package com.sessac.healthcare.domain.usecase

import com.sessac.healthcare.data.datasource.HistoryDataSource
import com.sessac.healthcare.data.datasource.impl.HistoryDataSourceImpl
import com.sessac.healthcare.domain.entites.ReportEntity

class GetUserTotalCarbonReductionUseCase(
    private val historyDataSource: HistoryDataSource = HistoryDataSourceImpl,
    private val reportEntity: ReportEntity = ReportEntity()
) {
    operator fun invoke(): Double {
        val userHistories = historyDataSource.getUserHistories("") // 내 정보 가져오기
        val totalDistanceWalked = userHistories.sumOf { it.distanceWalked }
        return reportEntity.calculateCarbonReduction(totalDistanceWalked)
    }
}