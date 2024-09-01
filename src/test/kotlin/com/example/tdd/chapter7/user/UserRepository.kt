package com.example.tdd.chapter7.user;

interface UserRepository {
    fun save(user: User)

    fun findById(id: String): User?
}