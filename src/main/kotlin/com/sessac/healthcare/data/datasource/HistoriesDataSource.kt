package com.sessac.healthcare.data.datasource

import com.sessac.healthcare.data.model.HistoryDataModel

interface HistoriesDataSource {

    fun getUserHistories(userId: String): List<HistoryDataModel>

    fun createUserHistory(historyDataModel: HistoryDataModel)

    fun updateUserHistory(historyDataModel: HistoryDataModel)

    fun deleteUserHistory(id: Long)
}