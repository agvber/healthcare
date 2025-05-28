package com.sessac.healthcare.domain.usecase

import com.sessac.healthcare.data.datasource.HistoriesDataSource
import com.sessac.healthcare.data.datasource.impl.FileHistoriesDataSource

// 사용자의 기록을 가져옴.
class GetUserHistoriesUseCase(
    private val historiesDataSource: HistoriesDataSource = FileHistoriesDataSource.getInstance()
) {
    operator fun invoke(userId: String) = historiesDataSource.getUserHistories(userId)
}