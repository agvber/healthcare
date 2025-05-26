package com.sessac.healthcare.domain.usecase


import com.sessac.healthcare.data.ds.HistoriesDataSource
import com.sessac.healthcare.data.ds.impl.HistoriesDataSourceImpl
import com.sessac.healthcare.data.model.NewUserDataModel
import com.sessac.healthcare.domain.SessionManager

class GetTotalWalkedDistanceUseCase(
    private val historiesDataSource: HistoriesDataSource = HistoriesDataSourceImpl,
    private val sessionManager: SessionManager = SessionManager.getInstance()
) {
    operator fun invoke(): Long {
        val user: NewUserDataModel = sessionManager.getUser()
        val histories = historiesDataSource.getUserHistories(user.userId) // 유저 정보 가져오기
        return histories

            .sumOf { it.distanceWalked }
    }
}