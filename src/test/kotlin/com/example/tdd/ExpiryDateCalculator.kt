package com.example.tdd

import org.springframework.stereotype.Service
import java.time.LocalDate
import kotlin.test.Test

@Service
class ExpiryDateCalculator {

    fun calculateExpiryDate(payData: PayData): LocalDate {
        payData.firstBillingDate?.let {
            // 첫 납부일과 납부일의 일자가 다르면 첫 납부일의 일자를 만료일의 일자로 사용

            // 후보 만료일 구함
            val candidateExp = payData.billingDate.plusMonths(1)

            // 첫 납부일의 일자와 후보 만료일의 일자가 다르면,
            if(payData.firstBillingDate.dayOfMonth != candidateExp.dayOfMonth) {
                // 첫 납부일의 일자를 후보 만료일의 일자로 사용
                return candidateExp.withDayOfMonth(
                    payData.firstBillingDate.dayOfMonth
                )
            }
        }

        return payData.billingDate.plusMonths(1)
    }

}