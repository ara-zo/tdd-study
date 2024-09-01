package com.example.tdd.chapter7.user


class MemoryUserRepository(
    private val users: HashMap<String, User> = HashMap()
) : UserRepository {
    override fun save(user: User) {
        users[user.id] = user
    }

    override fun findById(id: String): User? {
        return users[id]
    }
}