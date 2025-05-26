package com.sessac.healthcare.domain.usecase

import com.sessac.healthcare.data.datasource.GHistoryDataSource
import com.sessac.healthcare.data.model.GHistoryDataModel
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
            GHistoryDataSource = object : GHistoryDataSource {
                override fun getUserHistories(userId: Long): List<GHistoryDataModel> {
                    val dummy = GHistoryDataModel(
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
                ): List<GHistoryDataModel> {
                    TODO("Not yet implemented")
                }

                override fun getLastId(): Long {
                    TODO("Not yet implemented")
                }

                override fun setUserHistory(GHistoryDataModel: GHistoryDataModel) {
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