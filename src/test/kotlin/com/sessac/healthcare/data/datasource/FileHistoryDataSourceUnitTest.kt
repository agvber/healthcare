package com.sessac.healthcare.data.datasource

import com.sessac.healthcare.data.datasource.impl.FileHistoryDataSourceImpl
import com.sessac.healthcare.data.datasource.impl.FileUserDataSourceImpl
import com.sessac.healthcare.data.model.HistoryDataModel
import com.sessac.healthcare.data.utils.FileParsingUtil
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import java.io.File
import java.nio.file.Path
import java.time.LocalDateTime
import kotlin.io.path.Path
import kotlin.io.path.createFile
import kotlin.io.path.createParentDirectories
import kotlin.io.path.notExists

class FileHistoryDataSourceUnitTest {

    @Test
    fun `파일 읽기 쓰기를 검사합니다`() {
        val now = LocalDateTime.now()
        val historyDataModel = HistoryDataModel(
            id = 100,
            userId = 100,
            startDateTime = now.minusDays(1).minusHours(1),
            endDateTime = now.minusDays(1),
            memo = "memo",
            distanceWalked = 10000
        )
        historyDataSourceImpl.setUserHistory(historyDataModel)
        var result: String = ""
        file.forEachLine { result = it }
        Assertions.assertEquals(fileParsingUtil.formatString(historyDataModel), result)
    }

    companion object {

        private lateinit var file: File
        private lateinit var fileParsingUtil: FileParsingUtil
        private lateinit var historyDataSourceImpl: HistoryDataSource

        @BeforeAll
        @JvmStatic
        fun init() {
            val path: Path = Path("./data/test/history.txt").also {
                if (it.notExists()) {
                    it.createParentDirectories()
                    it.createFile()
                }
            }
            file = path.toFile()
            fileParsingUtil = FileParsingUtil()
            historyDataSourceImpl = FileHistoryDataSourceImpl(file, fileParsingUtil = fileParsingUtil)
        }
    }
}