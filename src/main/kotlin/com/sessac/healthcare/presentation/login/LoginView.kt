package com.sessac.healthcare.presentation.login

import com.sessac.healthcare.presentation.common.ViewScannerConsole

object LoginView {

    fun inputMainOption(): String? {
        println(StringResource.WELCOME_MESSAGE.trimIndent())
        print(StringResource.INPUT_PROMPT)
        return ViewScannerConsole.fetchReadLine()
    }

    fun printOptionSelectError() {
        println(StringResource.OPTION_ERROR)
    }

    fun inputId(): String? {
        print(StringResource.ID_PROMPT)
        return ViewScannerConsole.fetchReadLine()
    }

    fun inputPassword(): String? {
        print(StringResource.PASSWORD_PROMPT)
        return ViewScannerConsole.fetchReadLine()
    }

    fun printLoginErrorMessage() {
        println(StringResource.LOGIN_ERROR)
    }
}

private object StringResource {
    const val WELCOME_MESSAGE = """
            안녕하세요. 헬스케어 콘솔 프로젝트에 오신 것을 환영합니다.
            아래의 옵션을 선택하여 다음 화면을 진행하여주세요.
            [1] 로그인 [2] 회원가입 [0] 프로그램 종료
        """
    const val OPTION_ERROR = "해당 옵션은 존재하지 않습니다 다시 입력하여 주세요."
    const val LOGIN_ERROR = "아이디 또는 비밀번호가 일치하지 않습니다."
    const val INPUT_PROMPT = "입력): "
    const val ID_PROMPT = "아이디를 입력하여 주세요: "
    const val PASSWORD_PROMPT = "비밀번호를 입력하여 주세요: "
}
