package com.example.tdd

import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.YearMonth

@Service
class ExpiryDateCalculator {

    fun calculateExpiryDate(payData: PayData): LocalDate? {
        val addedMonths: Int = payData.payAmount / 10_000

        // 후보 만료일 구함
        val candidateExp = payData.billingDate.plusMonths(addedMonths.toLong())

        payData.firstBillingDate?.let {
            return expiryDateUsingFirstBillingDate(payData, candidateExp)
        } ?: candidateExp

        return payData.billingDate.plusMonths(addedMonths.toLong())
    }

    private fun expiryDateUsingFirstBillingDate(
        payData: PayData,
        candidateExp: LocalDate
    ): LocalDate? {
        val dayOfFirstBilling = payData.firstBillingDate!!.dayOfMonth

        // 첫 납부일의 일자와 후보 만료일의 일자가 다르면,
        if (isSameDayOfMonth(dayOfFirstBilling, candidateExp)) {
            val dayLenOfCandiMon = YearMonth.from(candidateExp).lengthOfMonth()

            // 후보 만료일이 포함된 달의 마지막날 < 첫 납부일의 일자
            if (lastDayOfMonth(dayLenOfCandiMon, dayOfFirstBilling)) {
                return candidateExp.withDayOfMonth(dayLenOfCandiMon)
            }

            // 첫 납부일의 일자를 후보 만료일의 일자로 사용
            return candidateExp.withDayOfMonth(dayOfFirstBilling)
        } else {
            return candidateExp
        }
    }

    private fun lastDayOfMonth(dayLenOfCandiMon: Int, dayOfFirstBilling: Int) = dayLenOfCandiMon < dayOfFirstBilling

    private fun isSameDayOfMonth(dayOfFirstBilling: Int, candidateExp: LocalDate) = dayOfFirstBilling != candidateExp.dayOfMonth

}