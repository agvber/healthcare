package com.sessac.healthcare.domain.usecase

import com.sessac.healthcare.data.datasource.HistoriesDataSource
import com.sessac.healthcare.data.datasource.impl.HistoriesDataSourceImpl

// 사용자의 기록을 가져옴.
class GetUserHistoriesUseCase(
    private val historiesDataSource: HistoriesDataSource = HistoriesDataSourceImpl
) {
    operator fun invoke(userId: String) = historiesDataSource.getUserHistories(userId)
}