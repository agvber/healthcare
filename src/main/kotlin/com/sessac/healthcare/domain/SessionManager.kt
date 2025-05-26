package com.sessac.healthcare.domain

import com.sessac.healthcare.data.model.NewUserDataModel

class SessionManager private constructor() {

    private lateinit var loggedInUser: NewUserDataModel

    fun getUser(): NewUserDataModel {
        return loggedInUser
    }

    fun setUser(user: NewUserDataModel) {
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