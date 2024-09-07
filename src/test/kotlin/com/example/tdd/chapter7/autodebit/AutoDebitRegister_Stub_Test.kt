package com.example.tdd.chapter7.autodebit

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AutoDebitRegister_Stub_Test(
    private var register: AutoDebitRegister,
    private var stubValidator: StubCardNumberValidator,
    private var stubRepository: StubAutoDebitInfoRepository
) {

    @BeforeEach
    fun setUp() {
        stubValidator = StubCardNumberValidator(invalidNo = null, theftNo = null)
        stubRepository = StubAutoDebitInfoRepository()
        register = AutoDebitRegister(stubValidator, stubRepository)
    }

    @Test
    fun invalidCard() {
        stubValidator.invalidNo = "1234567890123456"

        val req = AutoDebitReq("user1", "1234567890123456")
        val result = this.register.register(req)

        assertEquals(Cardvalidity.INVALID, result.validity)
    }

}