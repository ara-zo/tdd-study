package com.example.tdd.chapter7.user

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UserRegisterTest {
    private lateinit var userRegister: UserRegister
    private val stubPasswordChecker = StubWeakPasswordChecker(false)

    @BeforeEach
    fun setUp() {
        userRegister = UserRegister(stubPasswordChecker)
    }

    @Test
    @DisplayName("약한 암호면 가입 실패")
    fun weakPassword() {
        stubPasswordChecker.weak = true

        assertThrows<WeakPasswordException> {
            userRegister.register("id", "pw", "email")
        }
    }
}