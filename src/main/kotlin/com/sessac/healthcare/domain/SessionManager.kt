package com.sessac.healthcare.domain

import kotlin.properties.Delegates

class SessionManager private constructor() {

    private var loggedInUserId by Delegates.notNull<Long>()

    init {
        loggedInUserId = 0
    }

    fun getUserId(): Long {
        return loggedInUserId
    }

    fun setUserId(userId: Long) {
        loggedInUserId = userId
    }

    companion object {
        private var instance: SessionManager? = null

        @Synchronized
        fun getInstance(): SessionManager {
            return instance ?: SessionManager()
                .also { instance = it }
        }
    }
}