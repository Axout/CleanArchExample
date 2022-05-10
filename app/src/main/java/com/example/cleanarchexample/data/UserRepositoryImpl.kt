package com.example.cleanarchexample.data

import android.content.Context
import com.example.cleanarchexample.domain.models.SaveUserNameParam
import com.example.cleanarchexample.domain.models.UserName
import com.example.cleanarchexample.domain.repository.UserRepository

private const val SHARED_PREF_NAME = "shared_pref_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"
private const val DEFAULT_NAME = "Default last name"

// В data-слое никакой логики! Здесь только сохраняем и получаем значения.
// Логика - в domain-слое.

class UserRepositoryImpl(context: Context): UserRepository {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, saveParam.name).apply()
        return true
    }

    override fun getName(): UserName {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "") ?: ""
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_NAME) ?: DEFAULT_NAME
        return UserName(firstName, lastName)
    }
}
