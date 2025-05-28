package com.sessac.healthcare.presentation.userprofile

import com.sessac.healthcare.data.model.HistoryDataModel
import com.sessac.healthcare.data.model.UserDataModel
import com.sessac.healthcare.presentation.userprofile.controller.UserProfileController

class UserProfileControllerTest {

    private lateinit var user: UserDataModel
    private lateinit var histories: List<HistoryDataModel>
    private lateinit var controller: UserProfileController

//    @Test
//    fun `홈`(){
//        user = GUserDataSourceImpl.getUserById(1)
//        histories = GHistoryDataSourceImpl.getUserHistories(user.id)
//
//        controller = UserProfileController(user)
//
//        controller.launchUserProfile()
//    }
}