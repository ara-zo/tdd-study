package com.example.tdd.chapter7.autodebit

class JpaAutoDebitInfoRepository : AutoDebitInfoRepository {
    override fun save(info: AutoDebitInfo) {

    }

    override fun findOne(userId: String): AutoDebitInfo? {
        return null
    }
}