package com.example.tdd.chapter7.user

class StubWeakPasswordChecker(var weak: Boolean) : WeakPasswordChecker {
    override fun checkPasswordWeak(pw: String): Boolean {
        return weak
    }
}