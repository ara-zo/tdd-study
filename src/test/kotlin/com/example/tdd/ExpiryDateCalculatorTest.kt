package com.example.tdd

import java.time.LocalDate
import kotlin.test.Test
import kotlin.test.assertEquals

class ExpiryDateCalculatorTest {

    /**
     * 납부 금액 기준 서비스 만료일 계산
     *
     * 1. 서비스를 사용하려면 매달 1만원을 선불로 납부한다. 납부일 기준으로 한달 뒤가 서비스 만료일이 된다.
     * 2. 2개월 이상 요금을 납부할 수 있다.
     * 3. 10만 원을 납부하면 서비스를 1년 제공
     */

    /**
     * 1. 구현하기 쉬운 것부터 먼저 테스트
     * 2. 예외 상황을 먼저 테스트
     */
    @Test
    fun `만원_납부하면_한달_뒤가_만료일이_됨`( ) {
        assertExpiryDate(
            billingDate = LocalDate.of(2019, 3, 1),
            payAmount = 10_000,
            expectedExpiryDate = LocalDate.of(2019, 4, 1)
        )

        assertExpiryDate(
            billingDate = LocalDate.of(2019, 5, 5),
            payAmount = 10_000,
            expectedExpiryDate = LocalDate.of(2019,6,5)
        )
    }

    private fun assertExpiryDate(
        billingDate: LocalDate,
        payAmount: Int,
        expectedExpiryDate: LocalDate
    ) {
        val expiryDate = ExpiryDateCalculator.calculateExpiryDate(billingDate, payAmount)
        assertEquals(expectedExpiryDate, expiryDate)
    }


}