package com.sessac.healthcare.data.datasource.impl

import com.sessac.healthcare.common.anontation.ExperimentalFeatureApi
import com.sessac.healthcare.data.datasource.UserDataSource
import com.sessac.healthcare.data.model.UserDataModel
import com.sessac.healthcare.data.utils.FileParsingUtil
import com.sessac.healthcare.data.utils.LogUtils
import java.io.File
import kotlin.io.path.createFile
import kotlin.io.path.createParentDirectories
import kotlin.io.path.notExists

/**
 * 운동 정보를 저장한 파일에 데이터를 가져오는 클래스입니다.
 * 인스턴스를 직접 생성하지 말고 FileUserDataSource.getInstance() 함수를 호출해서 사용하세요!
 *
 * @property file 유저 파일
 * @property fileParsingUtil 유저의 파일 텍스트 값을 파싱 Utils class
 * @property userMap 유저의 데이터를 메모리 캐싱
 * @constructor Create empty User file data source imp
 */

class FileUserDataSource(
    private val file: File,
    private val fileParsingUtil: FileParsingUtil,
    private val userMap: LinkedHashMap<String, UserDataModel>
) : UserDataSource {

    init {
        checkFileStatus()
        loadData()
    }

    private fun checkFileStatus() = with(file.toPath()) {
        if (notExists()) {
            createParentDirectories()
            createFile()
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
                val userDataModel = fileParsingUtil.parseToObj(userTextLine, UserDataModel::class)
                userMap[userDataModel.userId] = userDataModel
            }
        }
    }

    override fun getUsers(): List<UserDataModel> {
        return userMap.values.toList()
    }

    override fun createUser(userDataModel: UserDataModel) {
        require(userDataModel.userId !in userMap.keys) { "이미 존재하는 아이디입니다." }
        userMap[userDataModel.userId] = userDataModel
    }

    override fun getUserById(id: String): UserDataModel {
        return userMap[id] ?: throw IllegalArgumentException("존재하지 않는 아이디입니다.")
    }

    override fun updateUser(userDataModel: UserDataModel) {
        userMap[userDataModel.userId] = userDataModel
    }

    override fun deleteUser(id: String) {
        userMap.remove(id)
    }

    override fun saveProgramData() {
        file.bufferedWriter().use { bufferedWriter ->
            userMap.forEach { (_, value) ->
                val objText = fileParsingUtil.formatString(value)
                bufferedWriter.write(objText)
                bufferedWriter.newLine()
            }
        }
    }

    companion object {
        const val TAG: String = "FileUserDataSource"
        private const val PATH_NAME: String = "./data/files/user.txt"

        private var instance: FileUserDataSource? = null

        fun getInstance(): FileUserDataSource {
            return instance ?: FileUserDataSource(
                file = File(PATH_NAME),
                fileParsingUtil = FileParsingUtil(),
                userMap = LinkedHashMap()
            ).also { instance = it }
        }
    }
}