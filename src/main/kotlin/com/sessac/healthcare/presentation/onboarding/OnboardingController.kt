package com.sessac.healthcare.presentation.onboarding

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
        onboardingView.printWelcomeMessage()
    }

    private fun inputUserInformation() {
        try {
            val userInformationString: String = onboardingView.inputUserInformation()
            onboardingPresentationModel = onboardingMapper.stringToOnboardingPresentationModel(userInformationString)
                .also {
                    registerUserInformationUseCase(
                        id = it.id,
                        password = it.password,
                        nickname = it.nickname,
                        height = it.height,
                        weight = it.weight
                    )
                }
        } catch (e: Exception) {
            onboardingView.printUserInformationInvalidError()
        }
    }
}