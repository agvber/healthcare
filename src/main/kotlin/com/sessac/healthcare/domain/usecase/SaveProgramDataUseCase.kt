package com.sessac.healthcare.domain.usecase

import com.sessac.healthcare.data.datasource.HistoriesDataSource
import com.sessac.healthcare.data.datasource.UserDataSource
import com.sessac.healthcare.data.datasource.impl.FileHistoriesDataSource
import com.sessac.healthcare.data.datasource.impl.FileUserDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.zip

class SaveProgramDataUseCase(
    private val userDataSource: UserDataSource = FileUserDataSource.getInstance(),
    private val historiesDataSource: HistoriesDataSource = FileHistoriesDataSource.getInstance()
) {

    operator fun invoke(): Flow<Result<Unit>> = userDataSource.saveProgramData().zip(
        historiesDataSource.saveProgramData()
    ) { t1, t2 ->
        if (t1.isFailure) return@zip t1
        if (t2.isFailure) return@zip t2
        Result.success(Unit)
    }

}
