package com.example.tdd

import org.junit.jupiter.api.assertThrows
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate
import kotlin.IllegalArgumentException
import kotlin.test.*
import kotlin.IllegalArgumentException as IllegalArgumentException1

@SpringBootTest
class methodTest {

    @Test
    fun `두 객체가 같은지 비교`() {
        val dateTime1 = LocalDate.now()
        val dateTime2 = LocalDate.now()
        assertEquals(dateTime1, dateTime2)
    }

    @Test
    fun `테스트 실패 알림`() {
        val thrown = assertThrows<IllegalArgumentException> {
            val dateTime1 = LocalDate.now()
            val dateTime2 = dateTime1.minusDays(1) // 날짜를 다르게 설정하여 테스트

            if (dateTime1 != dateTime2) {
                throw IllegalArgumentException("dateTime1 and dateTime2 are not equal")
            }

            assertEquals(dateTime1, dateTime2)
        }
        assertTrue(thrown.message?.contains("dateTime1") == true)
    }



}