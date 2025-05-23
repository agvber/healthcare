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
        return dummyHistoryModels.filter { history ->
            history.userId == userId &&
                    history.startDateTime.toLocalDate() >= startDate &&
                    history.startDateTime.toLocalDate() <= endDate
        }

    }

    override fun getLastId() = dummyHistoryModels.last().id

    override fun setUserHistory(historyDataModel: HistoryDataModel) {
        dummyHistoryModels.add(historyDataModel)
    }
}