package com.example.tdd.chapter5

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate
import kotlin.test.*

@SpringBootTest
class MethodTest {

    @Test
    fun `두_객체가_같은지_비교`() {
        val dateTime1 = LocalDate.now()
        val dateTime2 = LocalDate.now()
        assertEquals(dateTime1, dateTime2)
    }

    @Test
    fun `테스트_실패_알림`() {
        val thrown = assertThrows<IllegalArgumentException> {
            val dateTime1 = LocalDate.now()
            val dateTime2 = dateTime1.minusDays(1) // 날짜를 다르게 설정하여 테스트

            // 이부분 안넣으면 AssertionFailedError가 뜸
            if (dateTime1 != dateTime2) {
                throw IllegalArgumentException("dateTime1 and dateTime2 are not equal")
            }

            assertEquals(dateTime1, dateTime2)
        }
        assertTrue(thrown.message?.contains("dateTime1") == true)
    }

    @Disabled
    @Test
    fun `모든_검증_실행_후_실패_확인`() {
        assertAll(
            { assertEquals(3, 5/2) },
            { assertEquals(4, 2*1) },
            { assertEquals(6, 11/2) }
        )
    }
}