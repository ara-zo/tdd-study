package com.example.tdd.chapter10

import com.example.tdd.chapter7.user.WeakPasswordException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.BDDMockito
import org.mockito.Mockito

class `정확하게 일치하는 값으로 모의 객체 설정하지 않기` {
    /*
    // 안좋은 사례
    @Test
    fun weakPassword() {
        BDDMockito.given(mockPasswordChecker.checkPasswordWeak("pw")).willReturn(true)

        assertThrows<WeakPasswordException> {
            userRegister.register("id", "pw", "email")
        }
    }
    */

    // 개선된 사례
    @Test
    fun weakPassword() {
        BDDMockito.given(mockPasswordChecker.checkPasswordWeak(Mockito.anyString())).willReturn(true)

        assertThrows<WeakPasswordException> {
            userRegister.register("id", "pw", "email")
        }
    }
}