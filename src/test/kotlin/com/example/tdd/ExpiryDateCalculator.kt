package com.example.tdd

import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.YearMonth

@Service
class ExpiryDateCalculator {

    fun calculateExpiryDate(payData: PayData): LocalDate {
        val addedMonths: Int = payData.payAmount / 10_000

        payData.firstBillingDate?.let {
            // 첫 납부일과 납부일의 일자가 다르면 첫 납부일의 일자를 만료일의 일자로 사용

            // 후보 만료일 구함
            val candidateExp = payData.billingDate.plusMonths(addedMonths.toLong())

            // 첫 납부일의 일자와 후보 만료일의 일자가 다르면,
            if(payData.firstBillingDate.dayOfMonth != candidateExp.dayOfMonth) {
                // 후보 만료일이 포함된 달의 마지막날 < 첫 납부일의 일자
                if(YearMonth.from(candidateExp).lengthOfMonth() < payData.firstBillingDate.dayOfMonth) {
                    return candidateExp.withDayOfMonth(YearMonth.from(candidateExp).lengthOfMonth())
                }

                // 첫 납부일의 일자를 후보 만료일의 일자로 사용
                return candidateExp.withDayOfMonth(
                    payData.firstBillingDate.dayOfMonth
                )
            }
        }

        return payData.billingDate.plusMonths(addedMonths.toLong())
    }

}