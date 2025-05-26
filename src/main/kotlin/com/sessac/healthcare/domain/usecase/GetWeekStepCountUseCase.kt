package com.sessac.healthcare.domain.usecase

import com.sessac.healthcare.data.ds.HistoriesDataSource
import com.sessac.healthcare.data.ds.impl.HistoriesDataSourceImpl
import com.sessac.healthcare.data.model.NewUserDataModel
import com.sessac.healthcare.domain.SessionManager
import java.time.LocalDateTime

class GetWeekStepCountUseCase(
    private val historiesDataSource: HistoriesDataSource = HistoriesDataSourceImpl,
    private val sessionManager: SessionManager = SessionManager.getInstance()
) {
    operator fun invoke(): Long {
        val user: NewUserDataModel = sessionManager.getUser()

        val now: LocalDateTime = LocalDateTime.now()
        val minusOnWeekDateTime = now.minusWeeks(1)

        return historiesDataSource.getUserHistories(user.userId)
            .filter { it.endDateTime >= minusOnWeekDateTime }
            .sumOf { it.distanceWalked }
    }
}