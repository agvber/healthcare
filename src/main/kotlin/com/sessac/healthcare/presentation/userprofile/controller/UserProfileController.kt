package com.sessac.healthcare.presentation.userprofile.controller

import com.sessac.healthcare.data.model.GUserDataModel
import com.sessac.healthcare.presentation.userprofile.UserProfileUIMapper
import com.sessac.healthcare.presentation.userprofile.model.UserProfileUIModel
import com.sessac.healthcare.presentation.userprofile.ui.UserProfileView

class UserProfileController(
    private val user: GUserDataModel
) {
    private lateinit var userProfileUIModel: UserProfileUIModel

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
                    break
                }

                else -> println("잘못된 입력입니다.")
            }
        }
    }

    private fun saveUserProfile() {
        val updateUser = UserProfileUIMapper.mapToUserDataModel(userProfileUIModel, user)
        // 파일에 덮어쓰기 (파일 crud 구현되면 넣을 예정)
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
        applyChange: (T) -> Unit
    ) {
        val userInput = UserProfileView.inputNewValue(fieldName)
        val transValue = inputTransform(userInput)

        if (transValue != null) {
            applyChange(transValue)
            UserProfileView.displayUpdateSuccess(fieldName)
        } else {
            UserProfileView.displayUpdateFailure(fieldName, "제대로 입력하세요. ")
        }
    }
}