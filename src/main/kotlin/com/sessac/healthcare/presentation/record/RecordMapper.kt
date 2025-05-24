package com.sessac.healthcare.presentation.record

import com.sessac.healthcare.data.model.HistoryDataModel
import com.sessac.healthcare.data.utils.fileDateFormat
import com.sessac.healthcare.data.utils.toLocalDateTime
import java.time.Duration

class RecordMapper {
    fun historyDataModelToPresentation(history: HistoryDataModel): RecordPresentationModel {
        val duration = Duration.between(history.startDateTime, history.endDateTime)
        val hours = duration.toHours()
        val minutes = duration.toMinutesPart()
        val timeString = "${hours}시간 ${minutes}분"

        return RecordPresentationModel(
            userId = history.userId,
            startDateTime = history.startDateTime.format(fileDateFormat),
            time = timeString,
            distanceWalked = history.distanceWalked,
            memo = history.memo
        )
    }
        fun stringToHistoryDataModel(value: String, userId: String, lastPk: Long): HistoryDataModel {
        val record = value.split(",")
        return HistoryDataModel(
            userId = userId,
            startDateTime = record[0].trim().toLocalDateTime(),
            endDateTime = record[1].trim().toLocalDateTime(),
            pk = lastPk + 1,
            distanceWalked = record[2].trim().toLong(),
            memo = record[3].trim()
        )
    }
}