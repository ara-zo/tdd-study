package com.example.tdd.chapter7.autodebit

import java.io.IOException
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpRequest.BodyPublishers
import java.net.http.HttpResponse

open class CardNumberValidator(
    private var server: String? = null
) {

    open fun validate(cardNumber: String): Cardvalidity {
        val httpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(server + "/card"))
            .header("Content-Type", "text/plain")
            .POST(BodyPublishers.ofString(cardNumber))
            .build()

        try {
            val response = httpClient.send(request, HttpResponse.BodyHandlers.ofString())
            return when (response.body()) {
                "ok" -> Cardvalidity.VALID
                "bad" -> Cardvalidity.INVALID
                "expired" -> Cardvalidity.EXPIRED
                "theft" -> Cardvalidity.THEFT
                else -> Cardvalidity.UNKNOWN
            }
        // 코틀린은 Java처럼 멀티 캐치 블록이 안됨
        } catch (e : IOException) {
            return Cardvalidity.ERROR
        } catch (e: InterruptedException) {
            return Cardvalidity.ERROR
        }
    }
}