package com.example.tdd.chapter7

class MemoryAutoDebitInfoRepository(
    private val infos: HashMap<String, AutoDebitInfo> = HashMap()
) : AutoDebitInfoRepository {
    override fun save(info: AutoDebitInfo) {
        infos[info.userId] = info
    }

    override fun findOne(userId: String): AutoDebitInfo? {
        return infos[userId]
    }
}