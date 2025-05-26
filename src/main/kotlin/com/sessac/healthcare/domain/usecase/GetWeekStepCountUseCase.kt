package com.sessac.healthcare.domain.usecase

import com.sessac.healthcare.data.datasource.GHistoryDataSource
import com.sessac.healthcare.data.datasource.impl.GHistoryDataSourceImpl
import java.time.LocalDateTime

class GetWeekStepCountUseCase(
    private val GHistoryDataSource: GHistoryDataSource = GHistoryDataSourceImpl
) {
    operator fun invoke(): Long {
        val now: LocalDateTime = LocalDateTime.now()
        val minusOnWeekDateTime = now.minusWeeks(1)

        return GHistoryDataSource.getUserHistories("1")
            .filter { it.endDateTime >= minusOnWeekDateTime }
            .sumOf { it.distanceWalked }
    }
}