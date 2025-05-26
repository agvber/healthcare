package com.sessac.healthcare.data.datasource

import com.sessac.healthcare.data.datasource.impl.FileUserDataSourceImpl
import com.sessac.healthcare.data.model.UserDataModel
import com.sessac.healthcare.data.utils.FileParsingUtil
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import java.io.File
import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.createFile
import kotlin.io.path.createParentDirectories
import kotlin.io.path.notExists

class FileUserDataSourceUnitTest {

    @Test
    fun `파일 읽기 쓰기를 검사합니다`() {
//        val userDataModel = UserDataModel(0L, "nickname", 0, 10, 100L)
//        fileUserDataSourceImpl.setUser(userDataModel)
//        var result: String = ""
//        file.forEachLine { result = it }
//        Assertions.assertEquals(fileParsingUtil.formatString(userDataModel), result)
    }

    companion object {

        private lateinit var file: File
        private lateinit var fileParsingUtil: FileParsingUtil
        private lateinit var fileUserDataSourceImpl: FileUserDataSourceImpl

        @BeforeAll
        @JvmStatic
        fun init() {
            val path: Path = Path("./data/test/user.txt").also {
                if (it.notExists()) {
                    it.createParentDirectories()
                    it.createFile()
                }
            }
            file = path.toFile()
            fileParsingUtil = FileParsingUtil()
            fileUserDataSourceImpl = FileUserDataSourceImpl(file, fileParsingUtil = fileParsingUtil)
        }
    }
}