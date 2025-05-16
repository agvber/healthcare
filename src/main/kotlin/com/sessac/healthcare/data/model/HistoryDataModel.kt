package com.sessac.healthcare.data.model

import java.time.LocalDateTime

/**
 * History data model
 *
 * @property id
 * @property userId
 * @property startDateTime
 * @property endDateTime
 * @property memo
 * @property distanceWalked m단위
 * @constructor Create empty History data model
 */

data class HistoryDataModel(
    val id: Long,
    val userId: Long,
    val startDateTime: LocalDateTime,
    val endDateTime: LocalDateTime,
    val memo: String,
    val distanceWalked: Long
)