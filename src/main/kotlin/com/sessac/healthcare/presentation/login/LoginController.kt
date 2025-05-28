package com.sessac.healthcare.presentation.login

import com.sessac.healthcare.common.utils.printStackTraceWithDebugMode
import com.sessac.healthcare.domain.usecase.LoginUseCase
import com.sessac.healthcare.domain.usecase.SaveProgramDataUseCase
import com.sessac.healthcare.presentation.common.ViewController
import com.sessac.healthcare.presentation.home.controller.HomeController
import com.sessac.healthcare.presentation.onboarding.OnboardingController
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
        loginView = LoginView()
        loginUseCase = LoginUseCase()
    }

    private fun inputMainOption(): Unit = try {
        val selectedOption = loginView.inputMainOption()?.trim()?.toIntOrNull() ?: throw IllegalArgumentException()
        when (selectedOption) {
            1 -> inputLoginAccountInformation()
            2 -> {
                onboardingController.run()
                inputMainOption()
            }

            0 -> {
                SaveProgramDataUseCase().invoke()
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
    }
}