package com.sessac.healthcare.data.ds

import com.sessac.healthcare.data.model.NewHistoryDataModel

interface HistoriesDataSource {

    fun getUserHistories(userId: String): List<NewHistoryDataModel>

    fun createUserHistory(newHistoryDataModel: NewHistoryDataModel)

    fun updateUserHistory(newHistoryDataModel: NewHistoryDataModel)

    fun deleteUserHistory(id: Long)
}