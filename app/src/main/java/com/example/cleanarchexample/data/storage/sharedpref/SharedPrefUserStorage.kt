package com.example.cleanarchexample.data.storage.sharedpref

import android.content.Context
import com.example.cleanarchexample.data.storage.UserStorage
import com.example.cleanarchexample.data.storage.models.User

private const val SHARED_PREF_NAME = "shared_pref_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"
private const val DEFAULT_FIRST_NAME = "Ivan"
private const val DEFAULT_LAST_NAME = "Ivanov"

// Здесь также не должно быть никакой логики.
// Логика в Use Case
class SharedPrefUserStorage(context: Context): UserStorage {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, user.firstName).apply()
        sharedPreferences.edit().putString(KEY_LAST_NAME, user.lastName).apply()
        return true
    }

    override fun get(): User {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, DEFAULT_FIRST_NAME) ?: DEFAULT_FIRST_NAME
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_LAST_NAME) ?: DEFAULT_LAST_NAME
        return User(firstName, lastName)
    }

}