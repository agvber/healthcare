package com.sessac.healthcare.domain

class UserEntity {

    fun checkId(id: String): Boolean {
        // 중복 체크 로직
        return stringPattern.containsMatchIn(id)
    }

    fun checkPassword(password: String): Boolean {
        return stringPattern.containsMatchIn(password) &&
                password.length in passwordStringRange
    }

    fun checkNickname(nickname: String): Boolean {
        // 중복 체크 로직
        return stringPattern.containsMatchIn(nickname) &&
                nickname.length in nicknameStringRange
    }

    fun removeSecondFloatPlace(value: Float): Float {
        return String.format("%.2f", value).toFloat()
    }

    companion object {
        private val stringPattern: Regex = "^[a-zA-Z0-9\\s]+$".toRegex()
        private val passwordStringRange: IntRange = 4..16
        private val nicknameStringRange: IntRange = 4..8
    }
}