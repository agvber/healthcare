package com.sessac.healthcare.data.model.fake

import com.sessac.healthcare.data.model.NewUserDataModel

class DummyUserModels : DummyModel<List<NewUserDataModel>>() {

    override fun build(): List<NewUserDataModel> {
        return listOf(
            NewUserDataModel("mg", "1000", "민준", 175.1f, 70.1f, 10000, 1000, 5000),
            NewUserDataModel("mdg", "1000", "민준123", 175.1f, 70.1f, 10000, 1000, 5000),
        )
    }
}