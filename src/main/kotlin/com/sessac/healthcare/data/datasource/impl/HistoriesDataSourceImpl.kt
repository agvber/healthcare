package com.sessac.healthcare.data.datasource.impl

import com.sessac.healthcare.data.datasource.HistoriesDataSource
import com.sessac.healthcare.data.model.HistoryDataModel
import java.time.LocalDateTime

object HistoriesDataSourceImpl : HistoriesDataSource {


    override fun getUserHistories(userId: String): List<HistoryDataModel> {
        return dummyData.filter { it.userId == userId }
    }

    override fun createUserHistory(historyDataModel: HistoryDataModel) {
        dummyData.add(historyDataModel)
    }

    override fun updateUserHistory(historyDataModel: HistoryDataModel) {
        val index = dummyData.indexOfFirst {
            it.historyId == historyDataModel.historyId
        }
        dummyData[index] = historyDataModel
    }

    override fun deleteUserHistory(id: Long) {
        dummyData.removeIf { it.historyId == id }
    }

    override fun saveProgramData() {
        TODO("Not yet implemented")
    }


    private val dummyData = mutableListOf(
        HistoryDataModel(
            1L,
            "user1",
            LocalDateTime.of(2024, 5, 1, 8, 0),
            LocalDateTime.of(2024, 5, 1, 9, 0),
            3000L,
            "Morning walk"
        ),
        HistoryDataModel(
            2L,
            "user2",
            LocalDateTime.of(2024, 5, 2, 18, 0),
            LocalDateTime.of(2024, 5, 2, 18, 45),
            2500L,
            "Evening stroll"
        ),
        HistoryDataModel(
            3L,
            "user3",
            LocalDateTime.of(2024, 5, 3, 7, 30),
            LocalDateTime.of(2024, 5, 3, 8, 15),
            3200L,
            "Walk to the park"
        ),
        HistoryDataModel(
            4L,
            "user4",
            LocalDateTime.of(2024, 5, 4, 6, 0),
            LocalDateTime.of(2024, 5, 4, 6, 30),
            2000L,
            "Quick jog"
        ),
        HistoryDataModel(
            5L,
            "user1",
            LocalDateTime.of(2024, 5, 5, 20, 0),
            LocalDateTime.of(2024, 5, 5, 20, 40),
            2800L,
            "Evening walk"
        ),
        HistoryDataModel(
            6L,
            "user2",
            LocalDateTime.of(2024, 5, 6, 9, 0),
            LocalDateTime.of(2024, 5, 6, 10, 0),
            3500L,
            "Weekend walk"
        ),
        HistoryDataModel(
            7L,
            "user5",
            LocalDateTime.of(2024, 5, 7, 12, 0),
            LocalDateTime.of(2024, 5, 7, 12, 30),
            1800L,
            "Lunch walk"
        ),
        HistoryDataModel(
            8L,
            "user3",
            LocalDateTime.of(2024, 5, 8, 15, 0),
            LocalDateTime.of(2024, 5, 8, 15, 20),
            1200L,
            "Short walk"
        ),
        HistoryDataModel(
            9L,
            "user4",
            LocalDateTime.of(2024, 5, 9, 5, 45),
            LocalDateTime.of(2024, 5, 9, 6, 30),
            3100L,
            "Early morning walk"
        ),
        HistoryDataModel(
            10L,
            "user1",
            LocalDateTime.of(2024, 5, 10, 19, 0),
            LocalDateTime.of(2024, 5, 10, 19, 50),
            3300L,
            "Post-dinner walk"
        )

    )
}