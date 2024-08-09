package com.example.tdd

import kotlin.test.Test
import kotlin.test.assertEquals

class CalculatorTest {

    @Test
    fun plus() {
        val sum = Calculator.plus(1, 2)
        assertEquals(3, sum)
        assertEquals(5, Calculator.plus(4,1))
    }
}