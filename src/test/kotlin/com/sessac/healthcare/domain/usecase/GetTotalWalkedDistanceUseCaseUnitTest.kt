package com.sessac.healthcare.domain.usecase

import com.sessac.healthcare.data.datasource.HistoryDataSource
import com.sessac.healthcare.data.model.HistoryDataModel
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.LocalDateTime

class GetTotalWalkedDistanceUseCaseUnitTest {

    private lateinit var getTotalWalkedDistanceUseCase: GetTotalWalkedDistanceUseCase

    @BeforeEach
    fun init() {
        getTotalWalkedDistanceUseCase = GetTotalWalkedDistanceUseCase(
            historyDataSource = object : HistoryDataSource {
                override fun getUserHistories(userId: Long): List<HistoryDataModel> {
                    val dummy = HistoryDataModel(
                        id = 11,
                        userId = 111,
                        startDateTime = LocalDateTime.now().minusDays(11),
                        endDateTime = LocalDateTime.now().minusDays(11).plusMinutes(45),
                        memo = "체력 단련을 위한 조깅",
                        distanceWalked = 8000
                    )
                    return listOf(dummy, dummy)
                }

                override fun getUserHistoriesByPeriod(
                    userId: Long,
                    startDate: LocalDate,
                    endDate: LocalDate
                ): List<HistoryDataModel> {
                    TODO("Not yet implemented")
                }

                override fun getLastId(): Long {
                    TODO("Not yet implemented")
                }

                override fun setUserHistory(historyDataModel: HistoryDataModel) {
                    TODO("Not yet implemented")
                }

            }
        )
    }

    @Test
    fun testUseCase() {
        val totalWalkedDistance = getTotalWalkedDistanceUseCase()
        Assertions.assertEquals(16000, totalWalkedDistance)
    }

}