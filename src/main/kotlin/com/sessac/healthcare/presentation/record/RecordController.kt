package com.sessac.healthcare.presentation.record

import com.sessac.healthcare.data.datasource.HistoriesDataSource
import com.sessac.healthcare.data.datasource.impl.FileHistoriesDataSource
import com.sessac.healthcare.data.model.HistoryDataModel
import com.sessac.healthcare.domain.entites.SessionManager
import com.sessac.healthcare.presentation.common.ViewController

class RecordController : ViewController {

    private val sessionManager = SessionManager.getInstance()
    private val user = sessionManager.getUser()
    private val historyDataSource: HistoriesDataSource = FileHistoriesDataSource.getInstance()

    private lateinit var recordView: RecordView
    private lateinit var recordMapper: RecordMapper
    private lateinit var userRecords: List<HistoryDataModel>

    override fun run() {
        recordView = RecordView
        recordMapper = RecordMapper()
        showUserRecords()
        handleUserInput()
    }

    private fun showUserRecords() {
        recordView.printRecordDefaultMessage()
        userRecords = historyDataSource.getUserHistories(user.userId)
        val presentationModels = userRecords.map {
            recordMapper.historyDataModelToPresentation(it)
        }
        recordView.printUserRecords(presentationModels)
    }

    private fun handleUserInput() {
        when (recordView.askWantToRecord()) {
            HANDLE_INSERTION -> handleRecordInsertion()
            EXIT_UMBER -> return // 이전 화면으로 이동
            else -> recordView.printInvalidInputMessage()
        }
    }

    private fun handleRecordInsertion() {
        try {
            val userInput = recordView.inputRecord()
            val lastId = userRecords.lastOrNull()?.historyId ?: 0
            val newRecord = recordMapper.stringToHistoryDataModel(userInput, user.userId, lastId)

            historyDataSource.createUserHistory(newRecord)
            println("${historyDataSource.getUserHistories(user.userId).last()}") // 임시 확인용
            recordView.printRecordSuccessMessage()
            showUserRecords() // 업데이트된 기록 표시
        } catch (e: Exception) {
            recordView.printRecordFailureMessage(e.message ?: "알 수 없는 오류가 발생했습니다.")
        }
    }

    companion object {
        private const val HANDLE_INSERTION = "1"
        private const val EXIT_UMBER = "0"
    }

}