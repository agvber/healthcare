package com.sessac.healthcare.presentation.onboarding

object OnboardingView {

    fun printWelcomeMessage() {
        println(StringResource.WELCOME_MESSAGE)
    }

    fun inputUserInformation(): String {
        println(StringResource.INPUT_GUIDE.trimIndent())
        print(StringResource.INPUT_PROMPT)
        return readLine() ?: ""
    }

    fun printUserInformationInvalidError() {
        println(StringResource.INVALID_INPUT_ERROR)
    }

    fun printIdExistError() {
        println(StringResource.ID_EXIST_ERROR)
    }
}

private object StringResource {
    const val WELCOME_MESSAGE = "헬스 케어에 오신 것을 환영합니다."
    const val INPUT_GUIDE = """
            회원가입에 필요한 정보는 다음과 같습니다.
            아이디(특수문자 X), 비밀번호(4 ~ 16자리, 특수문자 X), 닉네임(4 ~ 8자리, 특수문자 X), 키(cm), 체중(kg) 순으로 입력하여 주세요.
        """
    const val INPUT_PROMPT = "입력): "
    const val INVALID_INPUT_ERROR = "입력 형식이 올바르지 않습니다. 다시 시도해주세요."
    const val ID_EXIST_ERROR = "해당 아이디는 이미 존재합니다. 다시 시도해주세요."
}
