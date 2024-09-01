package com.example.tdd.chapter9

import com.example.tdd.chapter7.autodebit.CardNumberValidator
import com.example.tdd.chapter7.autodebit.Cardvalidity
import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test
import kotlin.test.assertEquals


class CardNumberValidatorTest(
    private var wireMockServer: WireMockServer
) {
    @BeforeEach
    fun setUp() {
        wireMockServer = WireMockServer(8089)
        wireMockServer.start()
    }

    @AfterEach
    fun tearDown() {
        wireMockServer.stop()
    }

    @Test
    fun valid() {
        wireMockServer.stubFor(
            post(urlEqualTo("/card"))
                .withRequestBody(equalTo("1234567890"))
                .willReturn(
                    aResponse()
                        .withHeader("Content-Type", "text/plain")
                        .withStatus(200)
                        .withBody("ok")  // 응답 본문이 "ok"가 되어야 합니다.
                )
        )

        val validator = CardNumberValidator("http://localhost:8089")
        val validity: Cardvalidity = validator.validate("1234567890")
        assertEquals(Cardvalidity.VALID, validity)
    }

    @Test
    fun timeout() {
        wireMockServer.stubFor(
            post(urlEqualTo("/card"))
                .willReturn(aResponse().withFixedDelay(5000))
        )

        val validator = CardNumberValidator("http://localhost:8089")
        val validity: Cardvalidity = validator.validate("1234567890")
        assertEquals(Cardvalidity.TIMEOUT, validity)
    }

}