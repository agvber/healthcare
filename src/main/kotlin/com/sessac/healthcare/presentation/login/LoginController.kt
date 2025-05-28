package com.sessac.healthcare.presentation.login

import com.sessac.healthcare.domain.usecase.LoginUseCase
import com.sessac.healthcare.presentation.common.ViewController
import com.sessac.healthcare.presentation.common.loop
import com.sessac.healthcare.presentation.home.controller.HomeController
import com.sessac.healthcare.presentation.onboarding.OnboardingController
import kotlin.system.exitProcess

class LoginController : ViewController {

    private lateinit var loginView: LoginView
    private lateinit var loginPresentationModel: LoginPresentationModel
    private lateinit var loginUseCase: LoginUseCase

    private var mainOption: Int = 0

    override fun run() {
        initProgram()
        loop {
            inputMainOption()
            inputLoginAccountInformation()
        }
    }

    private fun initProgram() {
        loginView = LoginView()
        loginUseCase = LoginUseCase()
    }

    private fun inputMainOption() {
        try {
            mainOption = loginView.inputMainOption().trim().toInt()
            when (mainOption) {
                1 -> {}
                2 -> OnboardingController().run()
                3 -> exitProcess(0)
            }
        } catch (e: Exception) {
            loginView.printOptionSelectError()
            inputMainOption()
        }
    }

    private fun inputLoginAccountInformation() {
        if (mainOption != 1) return
        try {
            val id = loginView.inputId()
            val password = loginView.inputPassword()
            loginPresentationModel = LoginPresentationModel(id, password).also {
                loginUseCase(it.id, it.password)
            }
            HomeController().run()
        } catch (e: Exception) {
            loginView.printLoginErrorMessage()
        }
    }
}