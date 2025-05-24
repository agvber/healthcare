package com.sessac.healthcare.domain.usecase

import com.sessac.healthcare.data.datasource.HistoryDataSource
import com.sessac.healthcare.data.datasource.impl.HistoryDataSourceImpl
import java.time.LocalDateTime

class GetWeekStepCountUseCase(
    private val historyDataSource: HistoryDataSource = HistoryDataSourceImpl
) {
    operator fun invoke(): Long {
        val now: LocalDateTime = LocalDateTime.now()
        val minusOnWeekDateTime = now.minusWeeks(1)

        return historyDataSource.getUserHistories("1")
            .filter { it.endDateTime >= minusOnWeekDateTime }
            .sumOf { it.distanceWalked }
    }
}