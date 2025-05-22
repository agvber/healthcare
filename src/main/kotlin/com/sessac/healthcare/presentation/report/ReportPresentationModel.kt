package com.sessac.healthcare.presentation.report

data class ReportPresentationModel(
    var consoleMainOption: Int = 0,
    val username: String = "",
    val bmi: Float = 0f,
    val weight: Float = 0f,
    val height: Float = 0f,
    var totalWalkedDistance: Float = 0f,
    var cardonReduction: Float = 0f,
    var oneOfWeekStepCount: Long = 0
)