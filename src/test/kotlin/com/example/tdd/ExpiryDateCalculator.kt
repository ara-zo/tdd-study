package com.example.tdd

import java.time.LocalDate
import kotlin.test.Test

object ExpiryDateCalculator {

    fun calculateExpiryDate(billingDate: LocalDate, payAmount: Int): LocalDate {
        return billingDate.plusMonths(1)
    }

}