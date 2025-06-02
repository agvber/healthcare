package com.sessac.healthcare.presentation.login

import com.sessac.healthcare.common.utils.printStackTraceWithDebugMode
import com.sessac.healthcare.domain.usecase.LoginUseCase
import com.sessac.healthcare.domain.usecase.SaveProgramDataUseCase
import com.sessac.healthcare.presentation.common.ViewController
import com.sessac.healthcare.presentation.home.controller.HomeController
import com.sessac.healthcare.presentation.onboarding.OnboardingController
import kotlin.system.exitProcess

class LoginController : ViewController {

    private lateinit var loginUseCase: LoginUseCase

    private val onboardingController by lazy(LazyThreadSafetyMode.NONE) {
        OnboardingController()
    }

    override fun run() {
        initProgram()
        inputMainOption()
    }

    private fun initProgram() {
        loginUseCase = LoginUseCase()
    }

    private fun inputMainOption(): Result<Unit> = runCatching {
        val selectedOption = LoginView.inputMainOption()?.trim()?.toIntOrNull() ?: throw IllegalArgumentException()
        when (selectedOption) {
            LOGIN_NUMBER -> inputLoginAccountInformation()
            ONBOARDING_NUMBER -> {
                onboardingController.run()
                inputMainOption()
            }

            EXIT_NUMBER -> {
                SaveProgramDataUseCase().invoke()
                exitProcess(0)
            }
        }
    }
        .onFailure { e ->
            e.printStackTraceWithDebugMode()
            if (e.message != LOGIN_ERROR_MESSAGE) {
                LoginView.printOptionSelectError()
            }
            inputMainOption()
        }

    private fun inputLoginAccountInformation(): Unit = try {
        val id: String = LoginView.inputId() ?: throw IllegalArgumentException()
        val password: String = LoginView.inputPassword() ?: throw IllegalArgumentException()
        loginUseCase(id, password)
        HomeController().run()
    } catch (e: Exception) {
        e.printStackTraceWithDebugMode()
        LoginView.printLoginErrorMessage()
        throw IllegalArgumentException(LOGIN_ERROR_MESSAGE)
    }

    private companion object LoginUtils {
        const val LOGIN_ERROR_MESSAGE: String = "LoginFormatError"

        const val LOGIN_NUMBER = 1
        const val ONBOARDING_NUMBER = 2
        const val EXIT_NUMBER = 0
    }
}