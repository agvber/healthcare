package com.sessac.healthcare.presentation.login

class LoginView {

    fun inputMainOption(): String {
        println("""
            안녕하세요. 헬스케어 콘솔 프로젝트에 오신 것을 환영합니다.
            아래의 옵션을 선택하여 다음 화면을 진행하여주세요.
            [1] 로그인 [2] 회원가입 [3] 프로그램 종료 
        """.trimIndent())
        print("입력): ")
        return readLine()!!
    }

    fun printOptionSelectError() {
        println("해당 옵션은 존재하지 않습니다 다시입력하여주세요.")
    }

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