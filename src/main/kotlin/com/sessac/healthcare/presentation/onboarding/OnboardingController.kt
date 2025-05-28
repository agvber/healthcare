package com.sessac.healthcare.presentation.onboarding

import com.sessac.healthcare.common.utils.printStackTraceWithDebugMode
import com.sessac.healthcare.domain.exception.IdExistException
import com.sessac.healthcare.domain.usecase.RegisterUserInformationUseCase
import com.sessac.healthcare.presentation.common.ViewController

class OnboardingController : ViewController {

    private lateinit var onboardingView: OnboardingView
    private lateinit var onboardingMapper: OnboardingMapper
    private lateinit var onboardingPresentationModel: OnboardingPresentationModel
    private lateinit var registerUserInformationUseCase: RegisterUserInformationUseCase

    override fun run() {
        initProgram()
        inputUserInformation()
    }

    private fun initProgram() {
        onboardingView = OnboardingView()
        onboardingMapper = OnboardingMapper()
        registerUserInformationUseCase = RegisterUserInformationUseCase()
        onboardingView.printWelcomeMessage()
    }

    private fun inputUserInformation() {
        try {
            val userInformationString: String = onboardingView.inputUserInformation()
            onboardingPresentationModel = onboardingMapper.stringToOnboardingPresentationModel(userInformationString)
            registerUser()
        } catch (e: Exception) {
            e.printStackTraceWithDebugMode()
            if (e is IdExistException) {
                onboardingView.printIdExistError()
            } else {
                onboardingView.printUserInformationInvalidError()
            }
            inputUserInformation()
        }
    }

    private fun registerUser() = with(onboardingPresentationModel) {
        registerUserInformationUseCase(
            id = id,
            password = password,
            nickname = nickname,
            height = height,
            weight = weight
        )
    }
}