package com.sessac.healthcare.presentation.onboarding

import com.sessac.healthcare.common.utils.printStackTraceWithDebugMode
import com.sessac.healthcare.domain.UserEntity
import com.sessac.healthcare.presentation.common.ViewController

class OnboardingController : ViewController {

    private lateinit var onboardingView: OnboardingView
    private lateinit var onboardingMapper: OnboardingMapper
    private lateinit var onboardingPresentationModel: OnboardingPresentationModel
    private lateinit var userEntity: UserEntity

    override fun run() {
        initProgram()
        inputUserInformation()
    }

    private fun initProgram() {
        onboardingView = OnboardingView()
        userEntity = UserEntity()
        onboardingMapper = OnboardingMapper()
        onboardingView.printWelcomeMessage()
    }

    private fun inputUserInformation() {
        while (true) {
            try {
                val userInformationString: String = onboardingView.inputUserInformation()
                onboardingPresentationModel =
                    onboardingMapper.stringToOnboardingPresentationModel(userInformationString)
                        .let {
                            it.copy(
                                height = userEntity.removeSecondFloatPlace(it.height),
                                weight = userEntity.removeSecondFloatPlace(it.weight)
                            )
                        }
                checkUserInformation()
                break
            } catch (e: Exception) {
                onboardingView.printUserInformationInvalidError()
                e.printStackTraceWithDebugMode()
            }
        }
    }

    private fun checkUserInformation() = with(onboardingPresentationModel) {
        require(
            userEntity.checkId(id) &&
                    userEntity.checkPassword(password) &&
                    userEntity.checkNickname(nickname)
        )
    }
}