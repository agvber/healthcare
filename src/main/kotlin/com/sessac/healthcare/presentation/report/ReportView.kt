package com.sessac.healthcare.presentation.report

object ReportView {

    fun inputOption(): Int? {
        print(StringResource.REPORT_MENU.trimIndent())
        return readLine()?.trim()?.toIntOrNull()
    }

    fun inputRetryOption(): Int? {
        print(StringResource.INVALID_OPTION)
        return readLine()?.trim()?.toIntOrNull()
    }

    fun printUserTotalDistanceWalked(name: String, meter: Float) {
        println(StringResource.DISTANCE_MESSAGE.format(name, meter))
    }

    fun printUserCarbonReduction(name: String, reductionKg: Float) {
        println(StringResource.CARBON_REDUCTION_MESSAGE.format(name, reductionKg))
    }

    fun printUserSevenWeekStepCount(name: String, stepCount: Long) {
        println(StringResource.WEEKLY_STEP_MESSAGE.format(name, stepCount))
    }

    fun printUserHealthInformation(name: String, bmi: Float, height: Float, weight: Float) {
        println(StringResource.HEALTH_INFO_MESSAGE.format(name, bmi, height, weight))
    }

}

private object StringResource {
    const val REPORT_MENU = """
            [리포트]
            1. 총 걸은 거리 출력합니다.
            2. 총 걸은 거리의 비례하여 탄소 저감량 출력합니다.
            3. 7일 동안 총 걸음수를 출력합니다.
            4. 나의 BMI, 키, 체중을 출력합니다.
            0. 홈으로 가기
            번호를 선택하여 입력하여 주세요: 
        """
    const val INVALID_OPTION = "해당 옵션은 존재하지 않습니다. 다시 입력하여 주세요: "
    const val DISTANCE_MESSAGE = "%s님의 총거리는 %.2f m 입니다."
    const val CARBON_REDUCTION_MESSAGE = "%s님의 걷기를 통해 %.2f kg CO₂ 탄소량이 저감되었습니다."
    const val WEEKLY_STEP_MESSAGE = "%s님의 7일 동안 총 걸음수는 %d 입니다."
    const val HEALTH_INFO_MESSAGE = "%s님의 건강정보는 BMI: %.2f, 키: %.2f cm, 체중: %.2f kg 입니다."
}
