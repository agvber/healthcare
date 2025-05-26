package com.sessac.healthcare.domain.entites

import com.sessac.healthcare.data.model.UserDataModel

class SessionManager private constructor() {

    private lateinit var loggedInUser: UserDataModel

    fun getUser(): UserDataModel {
        return loggedInUser
    }

    fun setUser(user: UserDataModel) {
        loggedInUser = user
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