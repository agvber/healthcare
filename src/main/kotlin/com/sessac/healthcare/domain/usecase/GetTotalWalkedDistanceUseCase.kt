package com.sessac.healthcare.domain.usecase


import com.sessac.healthcare.data.datasource.HistoriesDataSource
import com.sessac.healthcare.data.datasource.impl.HistoriesDataSourceImpl
import com.sessac.healthcare.data.model.UserDataModel
import com.sessac.healthcare.domain.entites.SessionManager

class GetTotalWalkedDistanceUseCase(
    private val historiesDataSource: HistoriesDataSource = HistoriesDataSourceImpl,
    private val sessionManager: SessionManager = SessionManager.getInstance()
) {
    operator fun invoke(): Long {
        val user: UserDataModel = sessionManager.getUser()
        val histories = historiesDataSource.getUserHistories(user.userId) // 유저 정보 가져오기
        return histories

            .sumOf { it.distanceWalked }
    }
}