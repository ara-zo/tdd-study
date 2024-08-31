package com.example.tdd.chapter7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AutoDebitRegisterTest(
    private var register: AutoDebitRegister
) {
    @BeforeEach
    fun setUp() {
        val validator = CardNumberValidator()
        val repository = JpaAutoDebitInfoRepository()
        register = AutoDebitRegister(validator, repository)
    }

    @Test
    fun validCard() {
        // 업체에서 받은 테스트용 유효한 카드번호 사용
        val req = AutoDebitReq("user1", "1234123412341234")
        val result = this.register.register(req)
        assertEquals(Cardvalidity.VALID, result.validity)
    }

    @Test
    fun theftCard() {
        // 업체에서 받은 도난 테스트용 카드번호 사용
        val req = AutoDebitReq("user1", "1234567890123456")
        val result = this.register.register(req)
        assertEquals(Cardvalidity.THEFT, result.validity)
    }
}