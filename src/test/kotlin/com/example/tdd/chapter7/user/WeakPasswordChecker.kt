package com.example.tdd.chapter7.user

interface WeakPasswordChecker {
    fun checkPasswordWeak(pw: String): Boolean
}