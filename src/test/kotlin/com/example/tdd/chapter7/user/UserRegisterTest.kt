package com.example.tdd.chapter7.user

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class UserRegisterTest {
    private lateinit var userRegister: UserRegister
    private val stubPasswordChecker = StubWeakPasswordChecker(false)
    private val fakeRepository = MemoryUserRepository()

    @BeforeEach
    fun setUp() {
        userRegister = UserRegister(stubPasswordChecker, fakeRepository)
    }

    @Test
    @DisplayName("약한 암호면 가입 실패")
    fun weakPassword() {
        stubPasswordChecker.weak = true

        assertThrows<WeakPasswordException> {
            userRegister.register("id", "pw", "email")
        }
    }

    @Test
    @DisplayName("같은 아이디가 없으면 가입 성공")
    fun noDupIdRegisterSuccess() {
        userRegister.register("id", "pw", "email")

        val savedUser = fakeRepository.findById("id")
        assertEquals("id", savedUser?.id)
        assertEquals("email", savedUser?.email)
    }
}