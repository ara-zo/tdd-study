package com.example.tdd.chapter7

import java.time.LocalDateTime

class AutoDebitRegister(
    private val validator: CardNumberValidator,
    private val repository: AutoDebitInfoRepository,
) {
    fun register(req: AutoDebitReq): RegisterResult {
        val validity = validator.validate(req.cardNumber)
        if (validity != Cardvalidity.VALID) {
            return RegisterResult.error(validity)
        }
        val info: AutoDebitInfo? = repository.findOne(req.userId)
        if (info != null) {
            info.changeCardNumber(req.cardNumber)
        } else {
            val newInfo = AutoDebitInfo(req.userId, req.cardNumber, LocalDateTime.now())
            repository.save(newInfo)
        }

        return RegisterResult.success();
    }
}