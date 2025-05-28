package com.sessac.healthcare.domain.usecase

import com.sessac.healthcare.data.datasource.HistoriesDataSource
import com.sessac.healthcare.data.datasource.impl.FileHistoriesDataSource
import com.sessac.healthcare.data.model.UserDataModel
import com.sessac.healthcare.domain.entites.SessionManager
import java.time.LocalDateTime

class GetWeekStepCountUseCase(
    private val historiesDataSource: HistoriesDataSource = FileHistoriesDataSource.getInstance(),
    private val sessionManager: SessionManager = SessionManager.getInstance()
) {
    operator fun invoke(): Long {
        val user: UserDataModel = sessionManager.getUser()

        val now: LocalDateTime = LocalDateTime.now()
        val minusOnWeekDateTime = now.minusWeeks(1)

        return historiesDataSource.getUserHistories(user.userId)
            .filter { it.endDateTime >= minusOnWeekDateTime }
            .sumOf { it.distanceWalked }
    }
}