package com.sessac.healthcare.data.datasource.impl

import com.sessac.healthcare.data.datasource.UserDataSource
import com.sessac.healthcare.data.model.UserDataModel
import com.sessac.healthcare.data.utils.FileParsingUtil
import com.sessac.healthcare.data.utils.LogUtils
import java.io.File
import kotlin.io.path.Path
import kotlin.io.path.createFile
import kotlin.io.path.createParentDirectories
import kotlin.io.path.notExists

/**
 * 유저 정보를 저장한 파일에 데이터를 가져오는 클래스입니다.
 * 인스턴스를 직접 생성하지 말고 UserFileDataSourceImp.getInstance() 함수를 호출해서 사용하세요!
 *
 * @property file 유저 파일
 * @property fileParsingUtil 유저의 파일 텍스트 값을 파싱 Utils class
 * @constructor Create empty User file data source imp
 */

class FileUserDataSourceImpl(
    private val file: File,
    private val fileParsingUtil: FileParsingUtil
) : UserDataSource {

    override fun getUsers(): List<UserDataModel> {
        val result = mutableListOf<UserDataModel>()
        file.readLines().forEach { string ->
            if (!string.startsWith("<") || !string.endsWith("/>")) {
                LogUtils.printDebugLog(TAG, "file line error")
                return@forEach
            }
            val textLine = fileParsingUtil.parseToObj(string)
//            val userDataModel = UserDataModel(
//                id = textLine["id"].toString().toLong(),
//                nickname = textLine["nickname"].toString(),
//                height = textLine["height"].toString().toInt(),
//                weight = textLine["weight"].toString().toInt(),
//                goalDistance = textLine["goalDistance"].toString().toLong()
//            )
//            result.add(userDataModel)
        }
        return result
    }

    override fun setUser(userDataModel: UserDataModel) {
        val textLine = fileParsingUtil.formatString(obj = userDataModel)
        file.appendText("${textLine}\n")
    }

    override fun getUserById(id: Long): UserDataModel {
        file.readLines().forEach { string ->
            if (!string.startsWith("<") || !string.endsWith("/>")) {
                LogUtils.printDebugLog(TAG, "file line error")
                return@forEach
            }
            val textLine = fileParsingUtil.parseToObj(string)
//            if (textLine["id"] == id.toString()) {
//                return UserDataModel(
//                    id = textLine["id"].toString().toLong(),
//                    nickname = textLine["nickname"].toString(),
//                    height = textLine["height"].toString().toInt(),
//                    weight = textLine["weight"].toString().toInt(),
//                    goalDistance = textLine["goalDistance"].toString().toLong()
//                )
//            }
        }
        throw IllegalStateException()
    }

    override fun updateUser(userDataModel: UserDataModel) {
        TODO("Not yet implemented")
    }

    companion object {
        const val TAG: String = "UserFileDataSourceImpl"
        private const val PATH_NAME: String = "./data/files/users.txt"

        private var instance: FileUserDataSourceImpl? = null

        fun getInstance(): FileUserDataSourceImpl {
            return instance ?: FileUserDataSourceImpl(
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