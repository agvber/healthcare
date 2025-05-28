package com.sessac.healthcare.domain.usecase

import com.sessac.healthcare.data.datasource.HistoriesDataSource
import com.sessac.healthcare.data.datasource.UserDataSource
import com.sessac.healthcare.data.datasource.impl.FileHistoriesDataSource
import com.sessac.healthcare.data.datasource.impl.FileUserDataSource

class SaveProgramDataUseCase(
    private val userDataSource: UserDataSource = FileUserDataSource.getInstance(),
    private val historiesDataSource: HistoriesDataSource = FileHistoriesDataSource.getInstance()
) {

    operator fun invoke() {
        userDataSource.saveProgramData()
        historiesDataSource.saveProgramData()
    }
}