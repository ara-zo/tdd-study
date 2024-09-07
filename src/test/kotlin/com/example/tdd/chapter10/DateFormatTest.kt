package com.example.tdd.chapter10

import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate
import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals

@SpringBootTest
class DateFormatTest {

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


    private fun formatDate(date: LocalDate): String {
        return "${date.year}년 ${date.monthValue}월 ${date.dayOfMonth}일"
    }
}