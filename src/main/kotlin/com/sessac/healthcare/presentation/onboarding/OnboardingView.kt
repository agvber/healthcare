package com.sessac.healthcare.presentation.onboarding

class OnboardingView {

    fun printWelcomeMessage() {
        println("헬스 케어에 오신것을 환영합니다.")
    }

    fun inputLogin(): String {
        print("로그인하기 위해 아이디 비밀번호를 입력하여주세요. 예) ID, Password (콤마로 구분): ")
        return readLine() ?: ""
    }

    fun inputUserInformation(): String {
        println("회원가입에 필요한 정보는 다음과 같습니다.")
        println("아이디, 비밀번호, 닉네임, 키(cm), 체중(kg) 순으로 입력하여주세요.")
        print("입력): ")
        return readLine() ?: ""
    }

    fun printUserInformationInvalidError() {
        println("정보를 잘못 입력하셨습니다 다시 시도해주세요.")
    }
}