package com.example.tdd.chapter7

import java.time.LocalDateTime

class AutoDebitInfo(
    val userId: String,
    private var cardNumber: String,
    private var registrationDate: LocalDateTime,
) {
    fun changeCardNumber(cardNumber: String) {
        this.cardNumber = cardNumber
    }

    fun getCardNumber(): String {
        return this.cardNumber
    }
}