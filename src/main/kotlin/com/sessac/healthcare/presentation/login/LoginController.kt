package com.sessac.healthcare.presentation.login

import com.sessac.healthcare.domain.UserEntity
import com.sessac.healthcare.presentation.common.ViewController

class LoginController : ViewController {

    private lateinit var loginView: LoginView
    private lateinit var loginPresentationModel: LoginPresentationModel
    private lateinit var userEntity: UserEntity

    override fun run() {
        initProgram()
        inputLoginAccountInformation()
    }

    private fun initProgram() {
        loginView = LoginView()
        userEntity = UserEntity()
    }

    private fun inputLoginAccountInformation() {
        while (true) {
            runCatching {
                val id = loginView.inputId()
                val password = loginView.inputPassword()
                loginPresentationModel = LoginPresentationModel(id, password)
                checkLoginInformation()
                return
            }
                .onFailure {
                    loginView.printLoginErrorMessage()
                }
        }
    }

    private fun checkLoginInformation() {
        val isCheckedStatus = userEntity.checkId(loginPresentationModel.id) &&
                userEntity.checkPassword(loginPresentationModel.password)

        if (!isCheckedStatus) {
            throw IllegalArgumentException()
        }
    }
}