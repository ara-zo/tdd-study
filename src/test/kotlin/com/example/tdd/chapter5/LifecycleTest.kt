package com.example.tdd.chapter5

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.Test

@SpringBootTest
class LifecycleTest {
    init {
        println("new LifecycleTest")
    }

    @BeforeEach
    fun setUp() {
        println("setUp")
    }

    @Test
    fun a() {
        println("A")
    }

    @Test
    fun b() {
        println("B")
    }

    @AfterEach
    fun tearDown() {
        println("tearDown")
    }

}