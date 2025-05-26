package com.sessac.healthcare.domain.usecase

import com.sessac.healthcare.data.datasource.GHistoryDataSource
import com.sessac.healthcare.data.datasource.impl.GHistoryDataSourceImpl

class GetTotalWalkedDistanceUseCase(
    private val GHistoryDataSource: GHistoryDataSource = GHistoryDataSourceImpl
) {
    operator fun invoke(): Long {
        val histories = GHistoryDataSource.getUserHistories("0") // 유저 정보 가져오기
        return histories.sumOf { it.distanceWalked }
    }
}