package com.sessac.healthcare.data.datasource.impl

import com.sessac.healthcare.data.datasource.GHistoryDataSource
import com.sessac.healthcare.data.model.GHistoryDataModel
import com.sessac.healthcare.data.model.fake.DummyHistoryModels
import java.time.LocalDate

object GHistoryDataSourceImpl : GHistoryDataSource {

    private val GDummyHistoryModels: MutableList<GHistoryDataModel> = DummyHistoryModels().get().toMutableList()

    override fun getUserHistories(userId: String): List<GHistoryDataModel> {
        return GDummyHistoryModels.filter {
            it.userId == userId
        }
    }

    override fun getUserHistoriesByPeriod(
        userId: String,
        startDate: LocalDate,
        endDate: LocalDate,
    ): List<GHistoryDataModel> {
        return GDummyHistoryModels.filter { history ->
            history.userId == userId &&
                    history.startDateTime.toLocalDate() >= startDate &&
                    history.startDateTime.toLocalDate() <= endDate
        }

    }

    override fun getLastPk() = GDummyHistoryModels.last().pk

    override fun setUserHistory(GHistoryDataModel: GHistoryDataModel) {
        GDummyHistoryModels.add(GHistoryDataModel)
    }
}