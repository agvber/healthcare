package com.sessac.healthcare.presentation.onboarding

import com.sessac.healthcare.common.utils.printStackTraceWithDebugMode
import com.sessac.healthcare.domain.exception.IdExistException
import com.sessac.healthcare.domain.usecase.RegisterUserInformationUseCase
import com.sessac.healthcare.presentation.common.ViewController

class OnboardingController : ViewController {

    private lateinit var onboardingPresentationModel: OnboardingPresentationModel
    private lateinit var registerUserInformationUseCase: RegisterUserInformationUseCase

    override fun run() {
        initProgram()
        inputUserInformation()
    }

    private fun initProgram() {
        registerUserInformationUseCase = RegisterUserInformationUseCase()
        OnboardingView.printWelcomeMessage()
    }

    private fun inputUserInformation() {
        try {
            val userInformationString: String = OnboardingView.inputUserInformation()
            onboardingPresentationModel = OnboardingMapper.stringToOnboardingPresentationModel(userInformationString)
            registerUser()
        } catch (e: Exception) {
            e.printStackTraceWithDebugMode()
            if (e is IdExistException) {
                OnboardingView.printIdExistError()
            } else {
                OnboardingView.printUserInformationInvalidError()
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