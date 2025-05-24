package com.sessac.healthcare.data.model.fake

import com.sessac.healthcare.data.model.UserDataModel

class DummyUserModels : DummyModel<List<UserDataModel>>() {

    override fun build(): List<UserDataModel> {
        return listOf(
            UserDataModel(
                pk = 1L,
                nickname = "홍길동",
                height = 175.5f,
                weight = 70.0f,
                goalDistance = 10000L,    // 사용자가 설정한 목표 거리
                id = "hong123",
                password = "password123",
                dailyGoalDistance = 5000L,  // 일일 기본 목표 거리
                weeklyGoalDistance = 35000L  // 주간 기본 목표 거리
            ),
            UserDataModel(
                pk = 2L,
                nickname = "김철수",
                height = 180.0f,
                weight = 75.5f,
                goalDistance = 12000L,
                id = "kim456",
                password = "password456",
                dailyGoalDistance = 5000L,
                weeklyGoalDistance = 35000L
            ),
            UserDataModel(
                pk = 3L,
                nickname = "이영희",
                height = 165.0f,
                weight = 55.0f,
                goalDistance = 8000L,
                id = "lee789",
                password = "password789",
                dailyGoalDistance = 5000L,
                weeklyGoalDistance = 35000L
            )
        )

    }
}