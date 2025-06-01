package com.sessac.healthcare.data.datasource

import com.sessac.healthcare.data.datasource.impl.FileUserDataSource
import com.sessac.healthcare.data.model.UserDataModel
import com.sessac.healthcare.data.model.fake.DummyUserModels
import com.sessac.healthcare.data.utils.FileParsingUtil
import kotlinx.coroutines.Dispatchers
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.random.Random

class FileUserDataSourceUnitTest {

    @Test
    fun `파일 읽기 쓰기 테스트`() {
        val id = Random.nextInt(1000, 9999).toString()
        val user = DummyUserModels().get()[0].copy(userId = id)
        fileDataSource.createUser(user)
        fileDataSource.saveProgramData()

        var lastLine = ""
        file.useLines { it.forEach { lastLine = it } }

        val expect = fileParsingUtil.formatString(user)
        Assertions.assertEquals(expect, lastLine)
    }


    companion object {

        private lateinit var file: File
        private lateinit var fileParsingUtil: FileParsingUtil
        private lateinit var userMemoryMap: LinkedHashMap<String, UserDataModel>
        private lateinit var fileDataSource: FileUserDataSource

        @BeforeAll
        @JvmStatic
        fun init() {
            file = File("./data/test/user.txt")
            fileParsingUtil = FileParsingUtil()
            userMemoryMap = linkedMapOf()
            fileDataSource = FileUserDataSource(file, FileParsingUtil(), userMemoryMap, Dispatchers.IO)
        }

    }
}