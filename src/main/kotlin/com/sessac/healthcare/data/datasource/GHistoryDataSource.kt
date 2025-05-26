package com.sessac.healthcare.data.datasource

import com.sessac.healthcare.data.model.GHistoryDataModel
import java.time.LocalDate

interface GHistoryDataSource {

    fun getUserHistories(userId: String): List<GHistoryDataModel>

    fun getUserHistoriesByPeriod(
        userId: String,
        startDate: LocalDate,
        endDate: LocalDate,
    ): List<GHistoryDataModel>

    fun getLastPk(): Long

    fun setUserHistory(GHistoryDataModel: GHistoryDataModel)
}