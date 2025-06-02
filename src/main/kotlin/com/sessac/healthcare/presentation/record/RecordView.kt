package com.sessac.healthcare.presentation.record

import com.sessac.healthcare.presentation.record.constants.RecordStringResource as Res

object RecordView {
    fun printRecordDefaultMessage() {
        println(Res.HEADER)
        println(Res.WORK_OUT_RECORD)
    }

    fun printUserRecords(userRecord: List<RecordPresentationModel>) {
        userRecord.forEachIndexed { index, record ->
            println(
                String.format(
                    Res.RECORD_LIST_ITEM,
                    index + 1,
                    record.distanceWalked,
                    record.startDateTime,
                    record.time,
                    record.memo
                )
            )
        }
    }

    fun askWantToRecord(): String {
        println(Res.HEADER)
        println(Res.RECORD_OPTION)
        println(Res.GO_BACK_OPTION)
        println(Res.HEADER2)
        print(Res.SELECTION_PROMPT)
        return readLine() ?: ""
    }

    fun printInvalidInputMessage() {
        println(Res.INVALID_INPUT)
    }

    fun printRecordSuccessMessage() {
        println(Res.RECORD_SUCCESS)
    }

    fun printRecordFailureMessage(error: String) {
        println(Res.RECORD_FAILURE.format(error))
    }

    fun inputRecord(): String {
        println(Res.INPUT_GUIDE)
        println(Res.INPUT_FORMAT)
        println(Res.INPUT_EXAMPLE)
        print(Res.INPUT_PROMPT)
        return readLine() ?: ""
    }


}