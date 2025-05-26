package com.sessac.healthcare.domain.exception

class IdExistException : Exception(MESSAGE) {

    companion object {
        private const val MESSAGE = "아이디가 중복으로 인해 이미 다른 유저가 사용하고 있을 경우에 사용되는 에러입니다."
    }
}