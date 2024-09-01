package com.example.tdd.chapter7.user

class UserRegister(
    private val passwordChecker: WeakPasswordChecker
) {
    fun register(id: String, pw: String, email: String) {
        if (passwordChecker.checkPasswordWeak(pw)) {
            throw WeakPasswordException()
        }
    }
}