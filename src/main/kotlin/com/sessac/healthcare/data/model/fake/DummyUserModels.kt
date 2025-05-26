package com.sessac.healthcare.data.model.fake

import com.sessac.healthcare.data.model.NewUserDataModel

class DummyUserModels : DummyModel<List<NewUserDataModel>>() {

    override fun build(): List<NewUserDataModel> {
        return listOf(
            NewUserDataModel("mg", "mgmgmg12", "민규", 175.1f, 70.1f, 10000, 1000, 5000),)
    }
}