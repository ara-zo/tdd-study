package com.example.tdd.chapter7.autodebit


class StubCardNumberValidator(
    var invalidNo: String?,
    var theftNo: String?
) : CardNumberValidator() {

    override fun validate(cardNumber: String): Cardvalidity {
        if (invalidNo != null && invalidNo.equals(cardNumber)) {
            return Cardvalidity.INVALID
        }

        if (theftNo != null && theftNo.equals(cardNumber)) {
            return Cardvalidity.THEFT
        }

        return Cardvalidity.VALID
    }
}