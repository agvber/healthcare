package com.sessac.healthcare.presentation.userprofile.controller

import com.sessac.healthcare.data.datasource.impl.UserDataSourceImpl
import com.sessac.healthcare.data.model.UserDataModel
import com.sessac.healthcare.presentation.common.ViewController
import com.sessac.healthcare.presentation.userprofile.UserProfileUIMapper
import com.sessac.healthcare.presentation.userprofile.model.UserProfileUIModel
import com.sessac.healthcare.presentation.userprofile.ui.UserProfileView

class UserProfileController(
    private val user: UserDataModel,
) : ViewController {
    private lateinit var userProfileUIModel: UserProfileUIModel


    override fun run() {
        launchUserProfile()
    }

    fun launchUserProfile() {
        userProfileUIModel = UserProfileUIMapper.mapToUserProfileUIModel(user)
        while (true) {
            UserProfileView.displayUserInfo(userProfileUIModel)
            when (val menu = UserProfileView.displayEditMenu()) {
                "1" -> editNickName()
                "2" -> editHeight()
                "3" -> editWeight()
                "0" -> {
                    println("정보를 저장하고 뒤로 돌아갑니다.")
                    saveUserProfile()
                    return
                }

                else -> println("잘못된 입력입니다.")
            }
        }
    }

    private fun saveUserProfile() {
        val updateUser = UserProfileUIMapper.mapToUserDataModel(userProfileUIModel, user)
        UserDataSourceImpl.updateUser(updateUser)
        println("수정된 정보가 저장되었습니다: $updateUser")
    }

    private fun editNickName() {
        editField(
            fieldName = "이름",
            inputTransform = { input ->
                if (input.isNotEmpty()) input else null
            }
        ) { newValue ->
            userProfileUIModel.nickName = newValue
        }
    }

    private fun editHeight() {
        editField(
            fieldName = "키",
            inputTransform = { input ->
                if (input.isNotEmpty()) input.toFloatOrNull() else null
            }
        ) { newValue ->
            userProfileUIModel.height = newValue
        }
    }

    private fun editWeight() {
        editField(
            fieldName = "체중",
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
            .let(inputTransform)
            ?.also { applyChange(it) }
            ?.let { UserProfileView.displayUpdateSuccess(fieldName) }
            ?: UserProfileView.displayUpdateFailure(fieldName, "제대로 입력하세요.")
    }
}