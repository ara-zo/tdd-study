package com.example.tdd.chapter7

interface AutoDebitInfoRepository {
    fun save(info: AutoDebitInfo)

    fun findOne(userId: String): AutoDebitInfo?
}