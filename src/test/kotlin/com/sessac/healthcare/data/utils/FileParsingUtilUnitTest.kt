package com.sessac.healthcare.data.utils

import com.sessac.healthcare.common.anontation.ExperimentalFeatureApi
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class FileParsingUtilUnitTest {

    private lateinit var fileParsingUtil: FileParsingUtil
    private lateinit var testMap: Map<String, Any?>
    private lateinit var testStr: String

    @BeforeEach
    fun init() {
        fileParsingUtil = FileParsingUtil()
        testMap = mapOf(
            "a" to "b",
            "b" to "c",
            "d" to null
        )
        testStr = "<\"a\":\"b\",\"b\":\"c\",\"d\":\"null\"/>"
    }

    @Test
    fun writeTest() {
        val result = fileParsingUtil.formatString(testMap)
        Assertions.assertEquals(testStr, result)
    }

    @Test
    fun parseMapTest() {
        val result = fileParsingUtil.parseToObj(testStr)
        Assertions.assertEquals(testMap.toString(), result.toString())
    }

    @OptIn(ExperimentalFeatureApi::class)
    @Test
    fun parseObjTest() {
        val userFormatString = "<\"age\":\"12\",\"name\":\"MJ\"/>"
        val user = User("MJ", 12)
        val result = fileParsingUtil.parseToObj(userFormatString, User::class)
        Assertions.assertEquals(user, result)
    }

    @OptIn(ExperimentalFeatureApi::class)
    @Test
    fun readReflectionTest() {
        val user = "<\"age\":\"12\",\"name\":\"MJ\"/>"
        val result = fileParsingUtil.parseToObj(user, User::class)
        Assertions.assertEquals(User(name = "MJ", age = 12), result)
    }

    @Test
    fun refectionWritableTest() {
        val user = User(name = "MJ", age = 12)
        val result = fileParsingUtil.formatString(user)
        Assertions.assertEquals("<\"age\":\"12\",\"name\":\"MJ\"/>", result)
    }

    companion object {
        data class User(val name: String, val age: Int)
    }
}