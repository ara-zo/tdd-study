package com.example.tdd.chapter10

import org.junit.jupiter.api.assertAll
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate
import kotlin.test.Test
import kotlin.test.assertEquals

@SpringBootTest
class `변수나 필드를 사용해서 기댓값 표현하지 않기` {

    // 10.1 기대하는 값에 변수를 사용한 예
    /*
    @Test
    fun dateFormat() {
        val date = LocalDate.of(1945, 8, 15)
        val dateStr = formatDate(date)
        assertEquals(
            "${date.year}년 ${date.monthValue}월 ${date.dayOfMonth}일",
            dateStr
        )
    }
    */

    // 10.2 기대하는 값에 문자열 값을 사용한 예
    @Test
    fun dateFormat() {
        val date = LocalDate.of(1945, 8, 15)
        val dateStr = formatDate(date)
        assertEquals("1945년 8월 15일", dateStr)
    }

    /*
    // 10.3 단언과 객체 생성에 필드와 변수를 사용한 코드
    @Test
    fun checkArray() {
        assertAll(
            {assertEquals(answers[0], resultedAnswers[0])},
            { assertEquals(answers[1], resultedAnswers[1]) },
            { assertEquals(answers[2], resultedAnswers[2]) }
        )
    }
    */

    // 10.4 객체 생성과 단언에서 변수 대신 값을 사용
    @Test
    fun checkArray() {
        assertAll(
            { assertEquals(1, resultedAnswers[0]) },
            { assertEquals(2, resultedAnswers[1]) },
            { assertEquals(3, resultedAnswers[2]) }
        )
    }


    private fun formatDate(date: LocalDate): String {
        return "${date.year}년 ${date.monthValue}월 ${date.dayOfMonth}일"
    }
}