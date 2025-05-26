package com.sessac.healthcare.presentation.userprofile

import com.sessac.healthcare.data.model.NewUserDataModel
import com.sessac.healthcare.presentation.userprofile.model.UserProfileUIModel

object UserProfileUIMapper {

    fun mapToUserProfileUIModel(
        user: NewUserDataModel
    ): UserProfileUIModel = UserProfileUIModel(
        nickName = user.nickname,
        height = user.height,
        weight = user.weight,
    )

    // UIModel을 DataModel로 변환
    fun mapToUserDataModel(
        uiModel: UserProfileUIModel,
        dataModel: NewUserDataModel
    ) = NewUserDataModel(
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