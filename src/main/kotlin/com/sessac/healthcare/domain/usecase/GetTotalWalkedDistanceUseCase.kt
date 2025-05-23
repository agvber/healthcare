package com.sessac.healthcare.domain.usecase

import com.sessac.healthcare.data.datasource.HistoryDataSource
import com.sessac.healthcare.data.datasource.impl.HistoryDataSourceImpl

class GetTotalWalkedDistanceUseCase(
    private val historyDataSource: HistoryDataSource = HistoryDataSourceImpl
) {
    operator fun invoke(): Long {
        val histories = historyDataSource.getUserHistories(0) // 유저 정보 가져오기
        return histories.sumOf { it.distanceWalked }
    }
}