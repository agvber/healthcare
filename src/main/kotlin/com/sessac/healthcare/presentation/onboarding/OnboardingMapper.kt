package com.sessac.healthcare.presentation.onboarding

object OnboardingMapper {

    fun stringToOnboardingPresentationModel(value: String): OnboardingPresentationModel {
        val splitUserInfo = value.split(",")
        return OnboardingPresentationModel(
            id = splitUserInfo[0].trim(),
            password = splitUserInfo[1].trim(),
            nickname = splitUserInfo[2].trim(),
            height = splitUserInfo[3].trim().toFloat(),
            weight = splitUserInfo[4].trim().toFloat(),
        )
    }
}