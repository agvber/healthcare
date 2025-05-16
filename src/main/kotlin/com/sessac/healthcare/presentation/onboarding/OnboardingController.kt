package com.sessac.healthcare.presentation.onboarding

import com.sessac.healthcare.common.utils.printStackTraceWithDebugMode
import com.sessac.healthcare.presentation.common.ViewController

class OnboardingController : ViewController {

    private lateinit var onboardingView: OnboardingView
    private lateinit var onboardingMapper: OnboardingMapper
    private lateinit var onboardingPresentationModel: OnboardingPresentationModel

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
        while (true) {
            try {
                val userInformationString: String = onboardingView.inputUserInformation()
                onboardingPresentationModel =
                    onboardingMapper.stringToOnboardingPresentationModel(userInformationString)
                break
            } catch (e: Exception) {
                onboardingView.printUserInformationInvalidError()
                e.printStackTraceWithDebugMode()
            }
        }
    }
}