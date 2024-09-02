package com.example.tdd.chapter9

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.exchange
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.RequestEntity
import org.springframework.http.ResponseEntity
import java.net.URI
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserApiE2ETest {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Test
    fun weekPwResponse() {
        val reqBody = "{\"id\":\"id\",\"pw\":\"123\",\"email\":\"test@example.com\"}"
        val request = RequestEntity.post(URI.create("/user"))
            .contentType(MediaType.APPLICATION_JSON)
            .body(reqBody)

        val response: ResponseEntity<String> = restTemplate.exchange(request, String::class.java)

        assertEquals(HttpStatus.BAD_REQUEST, response.statusCode)
        response.body?.let { assertTrue(it.contains("WeakPasswordException")) }
    }

}