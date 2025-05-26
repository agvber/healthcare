package com.sessac.healthcare.presentation.report

class ReportView {

    fun inputOption(): Int? {
        print(
            """
            [리포트]
            1. 총 걸은 거리 출력합니다.
            2. 총 걸은 거리의 비례하여 탄소 처감량 출력합니다.
            3. 7일 동안 총 걸음수를 출력합니다.
            4. 나의 BMI, 키, 체중을 출력합니다.
            5. 홈으로 가기
            번호를 선택하여 입력하여주세요: 
        """.trimIndent()
        )
        return readLine()?.trim()?.toIntOrNull()
    }

    fun inputRetryOption(): Int? {
        print("해당 옵션 존재하지 않는 옵션입니다. 다시입력하여주세요: ")
        return readLine()?.trim()?.toIntOrNull()
    }

    fun printUserTotalDistanceWalked(
        name: String,
        meter: Float,
    ) {
        println("${name}님의 총거리는 ${meter}m 입니다.")
    }

    fun printUserCarbonReduction(
        name: String,
        reductionKg: Float,
    ) {
        println("${name}님의 걷기를 통해 ${reductionKg}kg CO₂ 탄소량이 저감되었습니다.")
    }

    fun printUserSevenWeekStepCount(
        name: String,
        stepCount: Long,
    ) {
        println("${name}님의 7일동안 총 걸음수는 ${stepCount}입니다.")
    }

    fun printUserHealthInformation(
        name: String,
        bmi: Float,
        height: Float,
        weight: Float,
    ) {
        println("${name}님의 건강정보는 BMI:$bmi 키:$height 체중:${weight}입니다.")
    }
}