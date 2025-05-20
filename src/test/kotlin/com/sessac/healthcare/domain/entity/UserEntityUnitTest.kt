package com.sessac.healthcare.domain.entity

import com.sessac.healthcare.domain.UserEntity
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.junit5.JUnit5Asserter

class UserEntityUnitTest {

    private lateinit var userEntity: UserEntity

    @BeforeEach
    fun init() {
        userEntity = UserEntity()
    }

    @Test
    fun `옳바른 아이디를 검사합니다`() {
        val actual = userEntity.checkId("abc")
        JUnit5Asserter.assertTrue(null, actual)
    }

    @Test
    fun `특수문자가 포함된 아이디를 검사합니다`() {
        val actual = userEntity.checkId("abc$%$#%@")
        JUnit5Asserter.assertTrue(null, !actual)
    }

    @Test
    fun `옳바른 비밀번호를 검사합니다`() {
        val actual = userEntity.checkPassword("abvsdaf123")
        JUnit5Asserter.assertTrue(null, actual)
    }

    @Test
    fun `특수문자가 포함된 비밀번호를 검사합니다`() {
        val actual = userEntity.checkId("abc$%$#%@")
        JUnit5Asserter.assertTrue(null, !actual)
    }

    @Test
    fun `4-16자리가 아닌 비밀번호를 검사합니다`() {
        val actual = userEntity.checkPassword("a")
        JUnit5Asserter.assertTrue(null, !actual)
    }

    @Test
    fun `옳바른 닉네임을 검사합니다`() {
        val actual = userEntity.checkNickname("nickname")
        JUnit5Asserter.assertTrue(null, actual)
    }

    @Test
    fun `특수문자가 포함된 닉네임을 검사합니다`() {
        val actual = userEntity.checkNickname("!@nickname")
        JUnit5Asserter.assertTrue(null, !actual)
    }

    @Test
    fun `4-8자리가 아닌 닉네임을 검사합니다`() {
        val actual = userEntity.checkNickname("123")
        JUnit5Asserter.assertTrue(null, !actual)
    }
}