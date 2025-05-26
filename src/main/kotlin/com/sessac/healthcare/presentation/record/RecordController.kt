package com.sessac.healthcare.presentation.record

import com.sessac.healthcare.data.datasource.impl.GHistoryDataSourceImpl
import com.sessac.healthcare.data.model.GHistoryDataModel
import com.sessac.healthcare.data.model.GUserDataModel
import com.sessac.healthcare.presentation.common.ViewController

class RecordController(
    private val user: GUserDataModel
) : ViewController {

    private lateinit var recordView: RecordView
    private lateinit var recordMapper: RecordMapper
    private lateinit var userRecords: List<GHistoryDataModel>

    override fun run() {
        recordView = RecordView()
        recordMapper = RecordMapper()
        showUserRecords()
        handleUserInput()
    }

    private fun showUserRecords() {
        recordView.printRecordDefaultMessage()
        userRecords = GHistoryDataSourceImpl.getUserHistories(user.id)
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
            val lastPk = GHistoryDataSourceImpl.getLastPk()
            val newRecord = recordMapper.stringToHistoryDataModel(userInput, user.id, lastPk)

            GHistoryDataSourceImpl.setUserHistory(newRecord)
            println("${GHistoryDataSourceImpl.getUserHistories(user.id).last()}") // 임시 확인용
            recordView.printRecordSuccessMessage()
            showUserRecords() // 업데이트된 기록 표시
        } catch (e: Exception) {
            recordView.printRecordFailureMessage(e.message ?: "알 수 없는 오류가 발생했습니다.")
        }
    }

}