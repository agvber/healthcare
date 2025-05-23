package com.sessac.healthcare.presentation.record

import com.sessac.healthcare.data.datasource.HistoryDataSource
import com.sessac.healthcare.data.model.HistoryDataModel
import com.sessac.healthcare.data.model.UserDataModel
import com.sessac.healthcare.presentation.common.ViewController

class RecordController(
    private val user: UserDataModel,
    private val historyDataSource: HistoryDataSource,
) : ViewController {

    private lateinit var recordView: RecordView
    private lateinit var recordMapper: RecordMapper
    private lateinit var userRecords: List<HistoryDataModel>

    override fun run() {
        recordView = RecordView()
        recordMapper = RecordMapper()
        showUserRecords()
        handleUserInput()
    }

    private fun showUserRecords() {
        recordView.printRecordDefaultMessage()
        userRecords = historyDataSource.getUserHistories(user.id)
        val presentationModels = userRecords.map {
            recordMapper.historyDataModelToPresentation(it)
        }
        recordView.printUserRecords(presentationModels)
    }

    private fun handleUserInput() {
        when (recordView.askWantToRecord()) {
            "1" -> handleRecordInsertion()
            "2" -> return // 이전 화면으로 이동
            else -> recordView.printInvalidInputMessage()
        }
    }

    private fun handleRecordInsertion() {
        try {
            val userInput = recordView.inputRecord()
            val lastId = historyDataSource.getLastId()
            val newRecord = recordMapper.stringToHistoryDataModel(userInput, user.id, lastId)

            historyDataSource.setUserHistory(newRecord)
            println("${historyDataSource.getUserHistories(user.id).last()}") // 임시 확인용
            recordView.printRecordSuccessMessage()
            showUserRecords() // 업데이트된 기록 표시
        } catch (e: Exception) {
            recordView.printRecordFailureMessage(e.message ?: "알 수 없는 오류가 발생했습니다.")
        }
    }

}