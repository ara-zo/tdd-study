package com.example.tdd

import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate
import kotlin.test.Test
import kotlin.test.assertEquals

@SpringBootTest
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
            PayData(
                billingDate = LocalDate.of(2019, 3, 1),
                payAmount = 10_000,
            ),
            expectedExpiryDate = LocalDate.of(2019, 4, 1)
        )

        assertExpiryDate(
            PayData(
                billingDate = LocalDate.of(2019, 5, 5),
                payAmount = 10_000,
            ),
            expectedExpiryDate = LocalDate.of(2019,6,5)
        )
    }

    @Test
    fun `납부일과_한달_뒤_일자가_같지_않음`() {
        assertExpiryDate(
            PayData(
                billingDate = LocalDate.of(2019,1,31),
                payAmount = 10_000,
            ),
            expectedExpiryDate = LocalDate.of(2019,2,28)
        )

        assertExpiryDate(
            PayData(
                billingDate = LocalDate.of(2019,5,31),
                payAmount = 10_000,
            ),
            expectedExpiryDate = LocalDate.of(2019,6,30)
        )

        assertExpiryDate(
            PayData(
                billingDate = LocalDate.of(2020,1,31),
                payAmount = 10_000,
            ),
            expectedExpiryDate = LocalDate.of(2020,2,29)
        )
    }

    @Test
    fun `첫_납부일과_만료일_일자가_다를때_만원_납부`() {
        assertExpiryDate(
            payData = PayData(
                firstBillingDate = LocalDate.of(2019,1,31),
                billingDate = LocalDate.of(2019,2,28),
                payAmount = 10_000
            ),
            expectedExpiryDate = LocalDate.of(2019,3,31)
        )

        // 첫 납부일이 2019-01-30이고 만료되는 2019-02-28에 1만원을 납부하면 다음 만료일은 2019-03-30
        assertExpiryDate(
            payData = PayData(
                firstBillingDate = LocalDate.of(2019,1,30),
                billingDate = LocalDate.of(2019,2,28),
                payAmount = 10_000
            ),
            expectedExpiryDate = LocalDate.of(2019,3,30)
        )

        // 첫 납부일이 2019-05-31이고 만료되는 2019-06-30dp 1만원을 납부하면 다음 만료일은 2019-07-31
        assertExpiryDate(
            payData = PayData(
                firstBillingDate = LocalDate.of(2019,5,31),
                billingDate = LocalDate.of(2019,6,30),
                payAmount = 10_000
            ),
            expectedExpiryDate = LocalDate.of(2019,7,31)
        )
    }

    @Test
    fun `이만원_이상_납부하면_비례해서_만료일_계산`() {
        assertExpiryDate(
            payData = PayData(
                billingDate = LocalDate.of(2019,3,1),
                payAmount = 20_000,
            ),
            expectedExpiryDate = LocalDate.of(2019,5,1)
        )

        assertExpiryDate(
            payData = PayData(
                billingDate = LocalDate.of(2019,3,1),
                payAmount = 30_000
            ),
            expectedExpiryDate = LocalDate.of(2019,6,1)
        )
    }

    // 첫 납부일이 2019-01-31이고 만료되는 2019-02-28에 2만원을 납부하면 다음 만료일은 2019-04-30
    @Test
    fun `첫_납부일과_만료일_일자가_다를때_이만원_이상_납부`() {
        assertExpiryDate(
            payData = PayData(
                firstBillingDate = LocalDate.of(2019,1,31),
                billingDate = LocalDate.of(2019,2,28),
                payAmount = 20_000,
            ),
            expectedExpiryDate = LocalDate.of(2019,4,30)
        )
    }

    private fun assertExpiryDate(
        payData: PayData,
        expectedExpiryDate: LocalDate
    ) {
        val cal = ExpiryDateCalculator()
        val expiryDate = cal.calculateExpiryDate(payData)
        assertEquals(expectedExpiryDate, expiryDate)
    }
}