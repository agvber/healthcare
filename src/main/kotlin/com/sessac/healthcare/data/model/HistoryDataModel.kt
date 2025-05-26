package com.sessac.healthcare.data.model

import java.time.LocalDateTime

data class HistoryDataModel(
    val id: Long,
    val userId: Long,
    val startDateTime: LocalDateTime,
    val endDateTime: LocalDateTime,
    val distanceWalked: Long,
    val memo: String,
)