package com.sessac.healthcare.presentation.record

data class RecordPresentationModel(
    val userId: Long,
    val startDateTime: String,
    val time: String,
    val distanceWalked: Long,
    val memo: String,
)
