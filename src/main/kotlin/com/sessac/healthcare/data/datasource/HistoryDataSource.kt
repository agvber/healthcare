package com.sessac.healthcare.data.datasource

import com.sessac.healthcare.data.model.HistoryDataModel
import java.time.LocalDate

interface HistoryDataSource {

    fun getUserHistories(userId: Long): List<HistoryDataModel>

    fun getUserHistoriesByPeriod(
        userId: Long,
        startDate: LocalDate,
        endDate: LocalDate,
    ): List<HistoryDataModel>

    fun getLastId(): Long

    fun setUserHistory(historyDataModel: HistoryDataModel)
}