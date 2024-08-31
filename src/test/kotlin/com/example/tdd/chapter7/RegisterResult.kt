package com.example.tdd.chapter7

class RegisterResult(
    val validity: Cardvalidity
) {
    companion object {
        fun error(validity: Cardvalidity): RegisterResult {
            return RegisterResult(validity)
        }

        fun success(): RegisterResult {
            return RegisterResult(Cardvalidity.VALID)
        }
    }
}