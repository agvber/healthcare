package com.sessac.healthcare.presentation.login

class LoginView {

    fun inputId(): String {
        print("아이디를 입력하여주세요: ")
        return readLine()!!
    }

    fun inputPassword(): String {
        print("비밀번호를 입력하여주세요: ")
        return readLine()!!
    }

    fun printLoginErrorMessage() {
        println("아이디와 비밀번호가 일치하지 않습니다.")
    }
}