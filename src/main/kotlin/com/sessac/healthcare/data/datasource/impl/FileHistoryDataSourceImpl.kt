package com.sessac.healthcare.data.datasource.impl

import com.sessac.healthcare.data.datasource.HistoryDataSource
import com.sessac.healthcare.data.model.HistoryDataModel
import com.sessac.healthcare.data.utils.FileParsingUtil
import com.sessac.healthcare.data.utils.LogUtils
import com.sessac.healthcare.data.utils.fileDateFormat
import java.io.File
import java.time.LocalDate
import java.time.LocalDateTime
import kotlin.io.path.Path
import kotlin.io.path.createFile
import kotlin.io.path.createParentDirectories
import kotlin.io.path.notExists

/**
 * 운동 정보를 저장한 파일에 데이터를 가져오는 클래스입니다.
 * 인스턴스를 직접 생성하지 말고 UserFileDataSourceImp.getInstance() 함수를 호출해서 사용하세요!
 *
 * @property file 유저 파일
 * @property fileParsingUtil 유저의 파일 텍스트 값을 파싱 Utils class
 * @constructor Create empty User file data source imp
 */

class FileHistoryDataSourceImpl(
    private val file: File,
    private val fileParsingUtil: FileParsingUtil
) : HistoryDataSource {

    override fun getUserHistories(userId: Long): List<HistoryDataModel> {
        val result = mutableListOf<HistoryDataModel>()
        file.forEachLine { textLine ->
            if (!textLine.startsWith("<") || !textLine.endsWith("/>")) {
                LogUtils.printDebugLog(TAG, "file line error")
                return@forEachLine
            }
            val historyMap = fileParsingUtil.parseToObj(textLine)
            val userDataModel = HistoryDataModel(
                id = historyMap["id"].toString().toLong(),
                userId = historyMap["userId"].toString().toLong(),
                startDateTime = LocalDateTime.parse(historyMap["startDateTime"].toString(), fileDateFormat),
                endDateTime = LocalDateTime.parse(historyMap["endDateTime"].toString(), fileDateFormat),
                memo = historyMap["memo"].toString(),
                distanceWalked = historyMap["distanceWalked"].toString().toLong()
            )
            result.add(userDataModel)
        }
        return result
    }

    override fun setUserHistory(historyDataModel: HistoryDataModel) {
        val historyStringModel = fileParsingUtil.formatString(historyDataModel)
        file.appendText("${historyStringModel}\n")
    }

    companion object {
        const val TAG: String = "FileHistoryDataSourceImpl"
        private const val PATH_NAME: String = "./data/files/histories.txt"

        private var instance: FileHistoryDataSourceImpl? = null

        fun getInstance(): FileHistoryDataSourceImpl {
            return instance ?: FileHistoryDataSourceImpl(
                file = Path(PATH_NAME).also {
                    if (it.notExists()) {
                        it.createParentDirectories()
                        it.createFile()
                    }
                }.toFile(),
                fileParsingUtil = FileParsingUtil()
            ).also { instance = it }
        }
    }
}