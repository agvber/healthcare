package com.sessac.healthcare.presentation.userprofile

import com.sessac.healthcare.data.datasource.impl.HistoryDataSourceImpl
import com.sessac.healthcare.data.datasource.impl.UserDataSourceImpl
import com.sessac.healthcare.data.model.HistoryDataModel
import com.sessac.healthcare.data.model.UserDataModel
import com.sessac.healthcare.presentation.home.controller.HomeController
import com.sessac.healthcare.presentation.home.ui.HomeView
import com.sessac.healthcare.presentation.userprofile.controller.UserProfileController
import org.junit.jupiter.api.Test

class UserProfileControllerTest {

    private lateinit var user: UserDataModel
    private lateinit var histories: List<HistoryDataModel>
    private lateinit var controller: UserProfileController

    @Test
    fun `홈`(){
        user = UserDataSourceImpl.getUserById(1)
        histories = HistoryDataSourceImpl.getUserHistories(user.id)

        controller = UserProfileController(user)

        controller.launchUserProfile()
    }
}