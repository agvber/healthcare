package com.sessac.healthcare.data.model

import java.time.LocalDateTime

data class HistoryDataModel(
    val historyId: Long,
    val userId: String,
    val startDateTime: LocalDateTime,
    val endDateTime: LocalDateTime,
    val distanceWalked: Long,
    val memo: String,
)