package com.example.tdd

import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.fail

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
        try {
            val dateTime1 = LocalDate.now()
            val dateTime2 = LocalDate.now()
            assertEquals(dateTime1, dateTime2)
            fail() // 이 지점에 다다르면 fail() 메서드는 테스트 실패 에러를 발생
        } catch (e: IllegalArgumentException) {

        }
    }
}