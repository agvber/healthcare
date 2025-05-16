package com.sessac.healthcare.data.datasource.impl

import com.sessac.healthcare.data.datasource.HistoryDataSource
import com.sessac.healthcare.data.model.HistoryDataModel
import com.sessac.healthcare.data.model.fake.DummyHistoryModels
import java.time.LocalDate

object HistoryDataSourceImpl : HistoryDataSource {

    private val dummyHistoryModels: MutableList<HistoryDataModel> = DummyHistoryModels().get().toMutableList()

    override fun getUserHistories(userId: Long): List<HistoryDataModel> {
        return dummyHistoryModels.filter {
            it.userId == userId
        }
    }

    override fun getUserHistoriesByPeriod(
        userId: Long,
        startDate: LocalDate,
        endDate: LocalDate,
    ): List<HistoryDataModel> {
        TODO("각자 구현 할것")
    }

    override fun setUserHistory(historyDataModel: HistoryDataModel) {
        dummyHistoryModels.add(historyDataModel)
    }
}