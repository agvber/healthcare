package com.sessac.healthcare.presentation.userprofile

import com.sessac.healthcare.data.model.UserDataModel
import com.sessac.healthcare.presentation.userprofile.model.UserProfileUIModel

object UserProfileUIMapper {

    fun mapToUserProfileUIModel(
        user: UserDataModel
    ): UserProfileUIModel = UserProfileUIModel(
        nickName = user.nickname,
        height = user.height,
        weight = user.weight,
    )

    // UIModel을 DataModel로 변환
    fun mapToUserDataModel(
        uiModel: UserProfileUIModel,
        dataModel: UserDataModel
    ) = UserDataModel(
        userId = dataModel.userId,
        nickname = uiModel.nickName,
        height = uiModel.height,
        weight = uiModel.weight,
        goalDistance = dataModel.goalDistance,
        password = dataModel.password,
        dailyGoalDistance = dataModel.dailyGoalDistance,
        weeklyGoalDistance = dataModel.weeklyGoalDistance
    )
}