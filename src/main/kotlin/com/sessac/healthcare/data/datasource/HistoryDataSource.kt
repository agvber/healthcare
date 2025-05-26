package com.sessac.healthcare.data.datasource

import com.sessac.healthcare.data.model.HistoryDataModel

interface HistoryDataSource {

    fun getUserHistories(userId: Long): List<HistoryDataModel>
    fun setUserHistory(historyDataModel: HistoryDataModel)
}