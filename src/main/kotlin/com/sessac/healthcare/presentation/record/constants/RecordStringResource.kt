package com.sessac.healthcare.presentation.record.constants

object RecordStringResource {
    const val HEADER = "\n=================================="
    const val HEADER2 = "=================================="
    const val WORK_OUT_RECORD = "운동기록"

    const val RECORD_LIST_ITEM =
        "(%d) 거리: %s, 시작 시간: %s, 운동 시간: %s, 메모: %s"

    const val RECORD_OPTION = "1. 운동 기록하기"
    const val GO_BACK_OPTION = "0. 이전 화면으로"
    const val SELECTION_PROMPT = "선택):  "

    const val INVALID_INPUT = "잘못된 입력값입니다."
    const val RECORD_SUCCESS = "운동 기록이 성공적으로 입력되었습니다."
    const val RECORD_FAILURE = "운동 기록 입력이 실패했습니다."

    const val INPUT_GUIDE = "\n운동 기록을 시작 시간, 종료 시간, 거리, 메모 순으로 입력해 주세요."
    const val INPUT_FORMAT = "입력 형식: YYYY-MM-DD HH:mm, YYYY-MM-DD HH:mm, 거리(m), 메모"
    const val INPUT_EXAMPLE = "(예시: 2024-03-21 14:30, 2024-03-21 15:30, 5000, 공원 산책)"
    const val INPUT_PROMPT = "입력): "

}