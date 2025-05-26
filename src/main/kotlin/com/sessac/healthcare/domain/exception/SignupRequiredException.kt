package com.sessac.healthcare.domain.exception

class SignupRequiredException : Exception(MESSAGE) {

    companion object {
        private const val MESSAGE: String = "회원가입이 필요한 사용자에게 표시되는 에러입니다."
    }
}