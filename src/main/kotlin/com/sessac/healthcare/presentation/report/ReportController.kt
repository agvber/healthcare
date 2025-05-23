package com.sessac.healthcare.presentation.report

import com.sessac.healthcare.domain.usecase.GetTotalWalkedDistanceUseCase
import com.sessac.healthcare.domain.usecase.GetUserInformationUseCase
import com.sessac.healthcare.domain.usecase.GetUserTotalCarbonReductionUseCase
import com.sessac.healthcare.domain.usecase.GetWeekStepCountUseCase
import com.sessac.healthcare.presentation.common.ViewController

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
        inputOptionNumber()
        processMain()
    }

    private fun initProgram() {
        reportView = ReportView()
        loadInitData()
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
        while (true) {
            reportView.inputOption()
                ?.also { reportPresentationModel.consoleMainOption = it }
                ?: reportView.printErrorMessage()
        }
    }

    private fun processMain() {
        when (reportPresentationModel.consoleMainOption) {
            1 -> processWalkedDistance()
            2 -> processCarbonReduction()
            3 -> processUserSevenWeekStepCount()
            4 -> processUserHealthInformation()
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
}