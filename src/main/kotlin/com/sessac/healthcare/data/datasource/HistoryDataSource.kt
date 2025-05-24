package com.sessac.healthcare.data.datasource

import com.sessac.healthcare.data.model.HistoryDataModel
import java.time.LocalDate

interface HistoryDataSource {

    fun getUserHistories(userId: String): List<HistoryDataModel>

    fun getUserHistoriesByPeriod(
        userId: String,
        startDate: LocalDate,
        endDate: LocalDate,
    ): List<HistoryDataModel>

    fun getLastPk(): Long

    fun setUserHistory(historyDataModel: HistoryDataModel)
}