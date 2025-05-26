package com.sessac.healthcare.data.datasource.impl

import com.sessac.healthcare.data.ds.HistoriesDataSource
import com.sessac.healthcare.data.model.NewHistoryDataModel
import com.sessac.healthcare.data.model.fake.DummyHistoryModels
import kotlin.collections.toMutableList

object HistoriesDataSourceImpl : HistoriesDataSource {

    private val dummyHistoryModels: MutableList<NewHistoryDataModel> = DummyHistoryModels().get().toMutableList()

    override fun getUserHistories(userId: String): List<NewHistoryDataModel> {
        return dummyHistoryModels.filter {
            it.userId == userId
        }
    }

    override fun createUserHistory(newHistoryDataModel: NewHistoryDataModel) {
        dummyHistoryModels.add(newHistoryDataModel)
    }

    override fun updateUserHistory(newHistoryDataModel: NewHistoryDataModel) {
        dummyHistoryModels[dummyHistoryModels.indexOfFirst {
            it.historyId == newHistoryDataModel.historyId
        }] = newHistoryDataModel

    }

    override fun deleteUserHistory(id: Long) {
        dummyHistoryModels.removeIf { it.historyId == id }
    }

}