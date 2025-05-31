package com.sessac.healthcare.data.datasource.impl

import com.sessac.healthcare.common.anontation.ExperimentalFeatureApi
import com.sessac.healthcare.data.datasource.HistoriesDataSource
import com.sessac.healthcare.data.model.HistoryDataModel
import com.sessac.healthcare.data.utils.FileParsingUtil
import com.sessac.healthcare.data.utils.LogUtils
import java.io.File
import kotlin.io.path.createFile
import kotlin.io.path.createParentDirectories
import kotlin.io.path.notExists

/**
 * 운동 정보를 저장한 파일에 데이터를 가져오는 클래스입니다.
 * 인스턴스를 직접 생성하지 말고 FileHistoriesDataSource.getInstance() 함수를 호출해서 사용하세요!
 *
 * @property file 유저 파일
 * @property fileParsingUtil 유저의 파일 텍스트 값을 파싱 Utils class
 * @property historyMap 유저의 운동 기록 데이터를 메모리 캐싱
 * @constructor Create empty User file data source imp
 */

class FileHistoriesDataSource(
    private val file: File,
    private val fileParsingUtil: FileParsingUtil,
    private val historyMap: LinkedHashMap<Long, HistoryDataModel>
) : HistoriesDataSource {

    private var cacheUserHistory: List<HistoryDataModel>? = null

    init {
        checkFileStatus()
        loadData()
    }

    private fun checkFileStatus() {
        val path = file.toPath()
        if (path.notExists()) {
            path.createParentDirectories()
            path.createFile()
        }
    }

    @OptIn(ExperimentalFeatureApi::class)
    private fun loadData() {
        file.useLines { sequence ->
            sequence.forEach { userTextLine ->
                if (!userTextLine.startsWith("<") || !userTextLine.endsWith("/>")) {
                    LogUtils.printDebugLog(TAG, "file line error")
                    return@forEach
                }
                val historyDataModel = fileParsingUtil.parseToObj(userTextLine, HistoryDataModel::class)
                historyMap[historyDataModel.historyId] = historyDataModel
            }
        }
    }

    override fun getUserHistories(userId: String): List<HistoryDataModel> {
        if (cacheUserHistory?.getOrNull(0)?.userId != userId) {
            cacheUserHistory = null
        }

        return cacheUserHistory ?: historyMap.values
            .filter { it.userId == userId }
            .also { cacheUserHistory = it }
    }

    override fun createUserHistory(historyDataModel: HistoryDataModel) {
        cacheUserHistory = null
        historyMap[historyDataModel.historyId] = historyDataModel.copy(historyId = historyMap.size - 1L)
    }

    override fun updateUserHistory(historyDataModel: HistoryDataModel) {
        cacheUserHistory = null
        historyMap[historyDataModel.historyId] = historyDataModel
    }

    override fun deleteUserHistory(id: Long) {
        cacheUserHistory = null
        historyMap.remove(id)
    }

    override fun saveProgramData() {
        file.bufferedWriter().use { bufferedWriter ->
            historyMap.forEach { (_, value) ->
                val objText = fileParsingUtil.formatString(value)
                bufferedWriter.write(objText)
                bufferedWriter.newLine()
            }
        }
    }

    companion object {
        const val TAG: String = "FileHistoriesDataSource"
        private const val PATH_NAME: String = "./data/files/histories.txt"

        private var instance: FileHistoriesDataSource? = null

        fun getInstance(): FileHistoriesDataSource {
            return instance ?: FileHistoriesDataSource(
                file = File(PATH_NAME),
                fileParsingUtil = FileParsingUtil(),
                historyMap = LinkedHashMap()
            ).also { instance = it }
        }
    }
}