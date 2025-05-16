package com.sessac.healthcare.data.model.fake

import com.sessac.healthcare.data.model.UserDataModel

class DummyUserModels : DummyModel<List<UserDataModel>>() {

    override fun build(): List<UserDataModel> {
        return listOf(
            UserDataModel(1, "민준", 175, 70, 10000),
            UserDataModel(2, "서연", 160, 55, 8000),
            UserDataModel(3, "지훈", 180, 85, 12000),
            UserDataModel(4, "하늘", 168, 62, 7500),
            UserDataModel(5, "도윤", 172, 68, 9500),
            UserDataModel(6, "가은", 158, 52, 7000),
            UserDataModel(7, "윤호", 177, 77, 11000),
            UserDataModel(8, "수아", 165, 58, 9000),
            UserDataModel(9, "태영", 182, 90, 13000),
            UserDataModel(10, "소민", 170, 65, 8500)
        )
    }
}