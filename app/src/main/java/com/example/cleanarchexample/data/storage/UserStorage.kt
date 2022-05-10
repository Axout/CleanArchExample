package com.example.cleanarchexample.data.storage

import com.example.cleanarchexample.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}