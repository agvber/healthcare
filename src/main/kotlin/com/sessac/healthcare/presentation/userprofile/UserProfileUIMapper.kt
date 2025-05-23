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

    /**
     * @param csvUser 유저 파일
     */
    fun mapToUserProfileUIModel(csvUser: String): UserProfileUIModel {
        // 유저 파일 -> id, name, 키, 몸무게, 목표 거리

        val userFields = csvUser.split(",").map { it.trim() }
        require(userFields.size == 5) { "유저 필드 정보가 잘못 되었습니다." }

        val userId = userFields[0].toLong()
        val nickname = userFields[1]
        val height = userFields[2].toInt()
        val weight = userFields[3].toInt()

        return UserProfileUIModel(
            id = userId,
            nickName = nickname,
            height = height,
            weight = weight
        )
    }


    // UIModel을 DataModel로 변환
    fun mapToUserDataModel(
        uiModel: UserProfileUIModel,
        dataModel: UserDataModel
    ) = UserDataModel(
        id = uiModel.id,
        nickname = uiModel.nickName,
        height = uiModel.height,
        weight = uiModel.weight,
        goalDistance = dataModel.goalDistance
    )
}