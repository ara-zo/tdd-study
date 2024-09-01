package com.example.tdd.chapter7.user

class SpyEmailNotifier(
    var called: Boolean,
    var email: String?,
) : EmailNotifier {
    override fun sendRegisterEmail(email: String) {
        called = true
        this.email = email
    }
}