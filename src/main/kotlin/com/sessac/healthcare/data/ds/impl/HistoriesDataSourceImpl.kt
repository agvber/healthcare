package com.sessac.healthcare.data.ds.impl

import com.sessac.healthcare.data.ds.HistoriesDataSource
import com.sessac.healthcare.data.model.NewHistoryDataModel
import java.time.LocalDateTime

object HistoriesDataSourceImpl : HistoriesDataSource {


    override fun getUserHistories(userId: String): List<NewHistoryDataModel> {
        return dummyData.filter { it.userId == userId }
    }

    override fun createUserHistory(newHistoryDataModel: NewHistoryDataModel) {
        dummyData.add(newHistoryDataModel)
    }

    override fun updateUserHistory(newHistoryDataModel: NewHistoryDataModel) {
        TODO("Not yet implemented")
    }

    override fun deleteUserHistory(id: Long) {
        TODO("Not yet implemented")
    }

    private val dummyData = mutableListOf(
        NewHistoryDataModel(
            1L,
            "user1",
            LocalDateTime.of(2024, 5, 1, 8, 0),
            LocalDateTime.of(2024, 5, 1, 9, 0),
            3000L,
            "Morning walk"
        ),
        NewHistoryDataModel(
            2L,
            "user2",
            LocalDateTime.of(2024, 5, 2, 18, 0),
            LocalDateTime.of(2024, 5, 2, 18, 45),
            2500L,
            "Evening stroll"
        ),
        NewHistoryDataModel(
            3L,
            "user3",
            LocalDateTime.of(2024, 5, 3, 7, 30),
            LocalDateTime.of(2024, 5, 3, 8, 15),
            3200L,
            "Walk to the park"
        ),
        NewHistoryDataModel(
            4L,
            "user4",
            LocalDateTime.of(2024, 5, 4, 6, 0),
            LocalDateTime.of(2024, 5, 4, 6, 30),
            2000L,
            "Quick jog"
        ),
        NewHistoryDataModel(
            5L,
            "user1",
            LocalDateTime.of(2024, 5, 5, 20, 0),
            LocalDateTime.of(2024, 5, 5, 20, 40),
            2800L,
            "Evening walk"
        ),
        NewHistoryDataModel(
            6L,
            "user2",
            LocalDateTime.of(2024, 5, 6, 9, 0),
            LocalDateTime.of(2024, 5, 6, 10, 0),
            3500L,
            "Weekend walk"
        ),
        NewHistoryDataModel(
            7L,
            "user5",
            LocalDateTime.of(2024, 5, 7, 12, 0),
            LocalDateTime.of(2024, 5, 7, 12, 30),
            1800L,
            "Lunch walk"
        ),
        NewHistoryDataModel(
            8L,
            "user3",
            LocalDateTime.of(2024, 5, 8, 15, 0),
            LocalDateTime.of(2024, 5, 8, 15, 20),
            1200L,
            "Short walk"
        ),
        NewHistoryDataModel(
            9L,
            "user4",
            LocalDateTime.of(2024, 5, 9, 5, 45),
            LocalDateTime.of(2024, 5, 9, 6, 30),
            3100L,
            "Early morning walk"
        ),
        NewHistoryDataModel(
            10L,
            "user1",
            LocalDateTime.of(2024, 5, 10, 19, 0),
            LocalDateTime.of(2024, 5, 10, 19, 50),
            3300L,
            "Post-dinner walk"
        )

    )
}