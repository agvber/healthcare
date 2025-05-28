package com.sessac.healthcare.presentation.userprofile.controller

import com.sessac.healthcare.domain.usecase.GetLoggedInUserUseCase
import com.sessac.healthcare.domain.usecase.UpdateUserProfileUseCase
import com.sessac.healthcare.presentation.common.ViewController
import com.sessac.healthcare.presentation.userprofile.UserProfileUIMapper
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
                "1" -> editNickName()
                "2" -> editHeight()
                "3" -> editWeight()
                "0" -> {
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
            inputTransform = { input ->
                if (input.isNotEmpty()) input else null
            }
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

    private inline fun <T> editField(
        fieldName: String,
        inputTransform: (String) -> T?,
        applyChange: (T) -> Unit,
    ) {
        UserProfileView.inputNewValue(fieldName)
            .trim()
            .let(inputTransform)
            ?.also { applyChange(it) }
            ?.let { UserProfileView.displayUpdateSuccess(fieldName) }
            ?: UserProfileView.displayUpdateFailure(fieldName)
    }
}