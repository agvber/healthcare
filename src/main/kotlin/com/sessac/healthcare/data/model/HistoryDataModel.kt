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
 * @property distanceWalked 하루 거리 (단위: m)
 * @constructor Create empty History data model
 */

data class HistoryDataModel(
    val pk: Long,
    val userId: String,
    val startDateTime: LocalDateTime,
    val endDateTime: LocalDateTime,
    val distanceWalked: Long,
    val memo: String,
)