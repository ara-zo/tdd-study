package com.example.tdd

import org.springframework.stereotype.Service
import java.time.LocalDate
import kotlin.test.Test

@Service
class ExpiryDateCalculator {

    fun calculateExpiryDate(payData: PayData): LocalDate {
        return payData.billingDate.plusMonths(1)
    }

}