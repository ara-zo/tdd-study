package com.example.tdd.chapter7

import java.time.LocalDateTime

class AutoDebitInfo(
    private val userId: String,
    private var cardNumber: String,
    private var registrationDate: LocalDateTime,
) {
    fun changeCardNumber(cardNumber: String) {
        this.cardNumber = cardNumber
    }
}