package com.sessac.healthcare.presentation.userprofile

import com.sessac.healthcare.data.model.UserDataModel
import com.sessac.healthcare.presentation.userprofile.model.UserProfileUIModel

object UserProfileUIMapper {

    fun mapToUserProfileUIModel(
        user: UserDataModel
    ): UserProfileUIModel = UserProfileUIModel(
        id = user.id,
        nickName = user.nickname,
        height = user.height,
        weight = user.weight,
    )

    // UIModel을 DataModel로 변환
    fun mapToUserDataModel(
        uiModel: UserProfileUIModel,
        dataModel: UserDataModel
    ) = UserDataModel(
        pk = 0,
        nickname = uiModel.nickName,
        height = uiModel.height,
        weight = uiModel.weight,
        goalDistance = dataModel.goalDistance,
        id = dataModel.id,
        password = dataModel.password,
        dailyGoalDistance = dataModel.dailyGoalDistance,
        weeklyGoalDistance = dataModel.weeklyGoalDistance
    )
}