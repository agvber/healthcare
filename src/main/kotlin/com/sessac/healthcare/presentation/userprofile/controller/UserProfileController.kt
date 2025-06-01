package com.sessac.healthcare.presentation.userprofile.controller

import com.sessac.healthcare.domain.usecase.GetLoggedInUserUseCase
import com.sessac.healthcare.domain.usecase.UpdateUserProfileUseCase
import com.sessac.healthcare.presentation.common.ViewController
import com.sessac.healthcare.presentation.userprofile.*
import com.sessac.healthcare.presentation.userprofile.model.Edit
import com.sessac.healthcare.presentation.userprofile.model.UserProfileUIModel
import com.sessac.healthcare.presentation.userprofile.ui.UserProfileView

class UserProfileController(
) : ViewController {
    private val getLoggedInUser = GetLoggedInUserUseCase()
    private val updateUserProfile = UpdateUserProfileUseCase()
    private val user = getLoggedInUser()

    private lateinit var userProfileUIModel: UserProfileUIModel

    override fun run() {
        launchUserProfile()
    }

    private fun launchUserProfile() {
        userProfileUIModel = UserProfileUIMapper.mapToUserProfileUIModel(user)
        while (true) {
            UserProfileView.displayUserInfo(userProfileUIModel)
            when (UserProfileView.displayEditMenu()) {
                NICKNAME_EDIT_NUMBER -> editNickName()
                HEIGHT_EDIT_NUMBER -> editHeight()
                WEIGHT_EDIT_NUMBER -> editWeight()
                EXIT_NUMBER -> {
                    saveUserProfile()
                    return
                }

                else -> UserProfileView.displayWrongInput()
            }
        }
    }

    private fun saveUserProfile() {
        val updateUser = UserProfileUIMapper.mapToUserDataModel(userProfileUIModel, user)
        updateUserProfile(updateUser)
        UserProfileView.displaySaveUserInfo(userProfileUIModel)
    }

    private fun editNickName() {
        editField(
            fieldName = Edit.NAME.fieldName,
            inputTransform = { input -> input.ifEmpty { null } }
        ) { newValue ->
            userProfileUIModel.nickName = newValue
        }
    }

    private fun editHeight() {
        editField(
            fieldName = Edit.HEIGHT.fieldName,
            inputTransform = { input ->
                if (input.isNotEmpty()) input.toFloatOrNull() else null
            }
        ) { newValue ->
            userProfileUIModel.height = newValue
        }
    }

    private fun editWeight() {
        editField(
            fieldName = Edit.WEIGHT.fieldName,
            inputTransform = { input ->
                if (input.isNotEmpty()) input.toFloatOrNull() else null
            }
        ) { newValue ->
            userProfileUIModel.weight = newValue
        }
    }
}