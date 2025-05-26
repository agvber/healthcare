package com.sessac.healthcare.data.model.fake

import com.sessac.healthcare.data.model.UserDataModel

class DummyUserModels : DummyModel<List<UserDataModel>>() {

    override fun build(): List<UserDataModel> {
        return listOf(
            UserDataModel(1, "민준", 175.1f, 70.1f, 10000, "mg", "1234", 1000, 5000),
            UserDataModel(2, "서연", 160.6f, 55.5f, 8000, "as", "5678", 1000, 5000),
            UserDataModel(3, "지훈", 180.4f, 85.7f, 12000, "dq", "8887", 1000, 5000),
            UserDataModel(4, "하늘", 168.6f, 62.9f, 7500, "gf", "5554", 1000, 5000)
        )
    }
}