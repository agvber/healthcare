package com.sessac.healthcare.presentation.login

import com.sessac.healthcare.common.utils.printStackTraceWithDebugMode
import com.sessac.healthcare.domain.usecase.LoginUseCase
import com.sessac.healthcare.domain.usecase.SaveProgramDataUseCase
import com.sessac.healthcare.presentation.common.ViewController
import com.sessac.healthcare.presentation.home.controller.HomeController
import com.sessac.healthcare.presentation.onboarding.OnboardingController
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlin.system.exitProcess

class LoginController : ViewController {

    private lateinit var loginView: LoginView
    private lateinit var loginUseCase: LoginUseCase

    private val onboardingController by lazy(LazyThreadSafetyMode.NONE) {
        OnboardingController()
    }

    override fun run() {
        initProgram()
        inputMainOption()
    }

    private fun initProgram() {
        loginView = LoginView
        loginUseCase = LoginUseCase()
    }

    private fun inputMainOption(): Unit = try {
        val selectedOption = loginView.inputMainOption()?.trim()?.toIntOrNull() ?: throw IllegalArgumentException()
        when (selectedOption) {
            LOGIN_NUMBER -> inputLoginAccountInformation()
            ONBOARDING_NUMBER -> {
                onboardingController.run()
                inputMainOption()
            }

            EXIT_NUMBER -> {
                runBlocking { SaveProgramDataUseCase().invoke().first() }
                    .onFailure {
                        // 사용자에게 저장 오류 표시
                    }
                exitProcess(0)
            }
        }
        Unit
    } catch (e: Exception) {
        e.printStackTraceWithDebugMode()
        if (e.message != LOGIN_ERROR_MESSAGE) {
            loginView.printOptionSelectError()
        }
        inputMainOption()
        Unit
    }

    private fun inputLoginAccountInformation(): Unit = try {
        val id: String = loginView.inputId() ?: throw IllegalArgumentException()
        val password: String = loginView.inputPassword() ?: throw IllegalArgumentException()
        loginUseCase(id, password)
        HomeController().run()
    } catch (e: Exception) {
        e.printStackTraceWithDebugMode()
        loginView.printLoginErrorMessage()
        throw IllegalArgumentException(LOGIN_ERROR_MESSAGE)
    }

    companion object {
        private const val LOGIN_ERROR_MESSAGE: String = "LoginFormatError"

        private const val LOGIN_NUMBER = 1
        private const val ONBOARDING_NUMBER = 2
        private const val EXIT_NUMBER = 0
    }
}