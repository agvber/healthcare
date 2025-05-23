package com.sessac.healthcare.presentation.onboarding

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.junit5.JUnit5Asserter

class OnboardingMapperUnitTest {

    private lateinit var onboardingMapper: OnboardingMapper

    @BeforeEach
    fun init() {
        onboardingMapper = OnboardingMapper()
    }

    @Test
    fun `유저 정보가 정상적으로 매핑되는지 체크합니다`() {
        val string = "id, pw, nick, 150, 10"
        val result: OnboardingPresentationModel = onboardingMapper.stringToOnboardingPresentationModel(string)
        val expectData = OnboardingPresentationModel(
            id = "id",
            password = "pw",
            nickname = "nick",
            height = 150f,
            weight = 10f
        )
        JUnit5Asserter.assertTrue(null, expectData == result)
    }
}