package com.sessac.healthcare.presentation.onboarding

class OnboardingView {

    fun printWelcomeMessage() {
        println("헬스 케어에 오신것을 환영합니다.")
    }

    fun inputUserInformation(): String {
        println("회원가입에 필요한 정보는 다음과 같습니다.")
        println("아이디(특수문자 X), 비밀번호(4 ~ 16자리, 특수문자 X), 닉네임(4 ~ 8자리, 특수문자 X), 키(cm), 체중(kg) 순으로 입력하여주세요.")
        print("입력): ")
        return readLine() ?: ""
    }

    fun printUserInformationInvalidError() {
        println("정보를 잘못 입력하셨습니다 다시 시도해주세요.")
    }
}