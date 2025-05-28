package com.sessac.healthcare.presentation.record

class RecordView {
    fun printRecordDefaultMessage() {
        println("\n==================================")
        println("운동 기록")
    }

    fun printUserRecords(userRecord: List<RecordPresentationModel>) {
        userRecord.forEachIndexed { index, record ->
            println("(${index + 1}) 거리: ${record.distanceWalked}, 시작 시간: ${record.startDateTime}, 운동 시간: ${record.time}, 메모: ${record.memo}")
        }
    }

    fun askWantToRecord(): String {
        println("\n==================================")
        println("1. 운동 기록하기")
        println("0. 이전 화면으로")
        println("==================================")
        print("선택):  ")
        return readLine() ?: ""
    }

    fun printInvalidInputMessage() {
        println("잘못된 입력값입니다.")
    }

    fun printRecordSuccessMessage() {
        println("운동 기록이 성공적으로 입력되었습니다.")
    }

    fun printRecordFailureMessage(error: String) {
        println("운동 기록 입력이 실패했습니다.")
    }

    fun inputRecord(): String {
        println("\n운동 기록을 시작 시간, 종료 시간, 거리, 메모 순으로 입력해 주세요.")
        println("입력 형식: YYYY-MM-DD HH:mm, YYYY-MM-DD HH:mm, 거리(m), 메모")
        println("(예시: 2024-03-21 14:30, 2024-03-21 15:30, 5000, 공원 산책)")
        print("입력): ")
        return readLine() ?: ""
    }


}