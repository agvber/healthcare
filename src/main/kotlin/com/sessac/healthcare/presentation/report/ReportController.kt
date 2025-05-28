package com.sessac.healthcare.presentation.report

import com.sessac.healthcare.domain.usecase.GetTotalWalkedDistanceUseCase
import com.sessac.healthcare.domain.usecase.GetUserInformationUseCase
import com.sessac.healthcare.domain.usecase.GetUserTotalCarbonReductionUseCase
import com.sessac.healthcare.domain.usecase.GetWeekStepCountUseCase
import com.sessac.healthcare.presentation.common.ViewController
import com.sessac.healthcare.presentation.common.loop

class ReportController : ViewController {

    private lateinit var reportView: ReportView
    private lateinit var reportPresentationModel: ReportPresentationModel

    private lateinit var getTotalWalkedDistanceUseCase: GetTotalWalkedDistanceUseCase
    private lateinit var getUserTotalCarbonReductionUseCase: GetUserTotalCarbonReductionUseCase
    private lateinit var getWeekStepCountUseCase: GetWeekStepCountUseCase
    private lateinit var getUserInformationUseCase: GetUserInformationUseCase

    override fun run() {
        initProgram()
        initUseCase()
        loadInitData()
        loop({ isContinue() }) {
            inputOptionNumber()
            processMain()
        }
    }

    private fun isContinue(): Boolean =
        reportPresentationModel.consoleMainOption != 0

    private fun initProgram() {
        reportView = ReportView
    }

    private fun initUseCase() {
        getTotalWalkedDistanceUseCase = GetTotalWalkedDistanceUseCase()
        getUserTotalCarbonReductionUseCase = GetUserTotalCarbonReductionUseCase()
        getWeekStepCountUseCase = GetWeekStepCountUseCase()
        getUserInformationUseCase = GetUserInformationUseCase()
    }

    private fun loadInitData() = with(getUserInformationUseCase()) {
        reportPresentationModel = ReportPresentationModel(
            username = nickname,
            weight = weight,
            height = height,
            bmi = bmi
        )
    }

    private fun inputOptionNumber() {
        val option: Int? = reportView.inputOption()

        if (option != null && option in mainOptionRange) {
            reportPresentationModel.consoleMainOption = option
            return
        }
        inputRetryOptionNumber()
    }

    private fun inputRetryOptionNumber() {
        val option: Int? = reportView.inputRetryOption()

        if (option == null || option !in mainOptionRange) {
            inputRetryOptionNumber()
            return
        }
        reportPresentationModel.consoleMainOption = option
    }

    private fun processMain() {
        when (reportPresentationModel.consoleMainOption) {
            WALKED_DISTANCE_NUMBER -> processWalkedDistance()
            CARBON_REDUCTION_NUMBER -> processCarbonReduction()
            SEVEN_WEEK_STEP_COUNT_NUMBER -> processUserSevenWeekStepCount()
            HEALTH_INFORMATION_NUMBER -> processUserHealthInformation()
        }
    }

    private fun processWalkedDistance() = with(reportPresentationModel) {
        if (totalWalkedDistance == 0f) {
            totalWalkedDistance = getTotalWalkedDistanceUseCase().toFloat()
        }

        reportView.printUserTotalDistanceWalked(
            name = username,
            meter = totalWalkedDistance
        )
    }

    private fun processCarbonReduction() = with(reportPresentationModel) {
        if (cardonReduction == 0f) {
            cardonReduction = getUserTotalCarbonReductionUseCase().toFloat()
        }

        reportView.printUserCarbonReduction(
            name = username,
            reductionKg = cardonReduction
        )
    }

    private fun processUserSevenWeekStepCount() = with(reportPresentationModel) {
        if (oneOfWeekStepCount == 0L) {
            oneOfWeekStepCount = getWeekStepCountUseCase()
        }

        reportView.printUserSevenWeekStepCount(
            name = username,
            stepCount = oneOfWeekStepCount
        )
    }

    private fun processUserHealthInformation() = with(reportPresentationModel) {
        reportView.printUserHealthInformation(
            name = username,
            bmi = bmi,
            height = height,
            weight = weight
        )
    }

    companion object {
        private val mainOptionRange: IntRange = 0..4

        private const val WALKED_DISTANCE_NUMBER = 1
        private const val CARBON_REDUCTION_NUMBER = 2
        private const val SEVEN_WEEK_STEP_COUNT_NUMBER = 3
        private const val HEALTH_INFORMATION_NUMBER = 4
    }
}