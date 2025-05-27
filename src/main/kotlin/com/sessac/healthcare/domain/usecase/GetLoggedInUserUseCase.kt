package com.sessac.healthcare.domain.usecase

import com.sessac.healthcare.domain.entites.SessionManager

// 로그인 된 사용자를 가져옴.
class GetLoggedInUserUseCase(
    private val sessionManager: SessionManager = SessionManager.getInstance()
) {

    operator fun invoke() = sessionManager.getUser()
}