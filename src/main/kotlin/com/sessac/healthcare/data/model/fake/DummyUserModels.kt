package com.sessac.healthcare.data.model.fake

import com.sessac.healthcare.data.model.UserDataModel

class DummyUserModels : DummyModel<List<UserDataModel>>() {

    override fun build(): List<UserDataModel> {
        return listOf(
            UserDataModel("mg", "mgmgmg12", "민규", 175.1f, 70.1f, 10000, 1000, 5000),
        )
    }
}