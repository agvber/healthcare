package com.sessac.healthcare.domain.usecase

import com.sessac.healthcare.data.datasource.HistoryDataSource
import com.sessac.healthcare.data.model.HistoryDataModel
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.LocalDateTime

class GetWeekStepCountUseCaseUnitTest {

    private lateinit var getWeekStepCountUseCase: GetWeekStepCountUseCase

    @BeforeEach
    fun init() {
        getWeekStepCountUseCase = GetWeekStepCountUseCase(
            object : HistoryDataSource {
                override fun getUserHistories(userId: Long): List<HistoryDataModel> {
                    val now = LocalDateTime.now()

                    val dummy = HistoryDataModel(
                        id = 11,
                        userId = 111,
                        startDateTime = now.minusDays(8),
                        endDateTime = now.minusDays(8).plusMinutes(45),
                        memo = "체력 단련을 위한 조깅",
                        distanceWalked = 8000
                    )


                    return listOf(
                        dummy,
                        dummy.copy(
                            endDateTime = now,
                            distanceWalked = 1
                        ),
                        dummy.copy(
                            startDateTime = now.minusDays(4),
                            endDateTime = now.minusDays(4),
                            distanceWalked = 1
                        ),
                        dummy.copy(
                            startDateTime = now.minusDays(5),
                            endDateTime = now.minusDays(5),
                            distanceWalked = 1
                        ),
                        dummy.copy(
                            startDateTime = now.minusDays(6),
                            endDateTime = now.minusDays(6),
                            distanceWalked = 1
                        ),
                        dummy.copy(
                            startDateTime = now.minusDays(7),
                            endDateTime = now.minusDays(7),
                            distanceWalked = 1
                        ),
                    )
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
        val stepCount = getWeekStepCountUseCase()
        Assertions.assertEquals(5, stepCount)
    }
}