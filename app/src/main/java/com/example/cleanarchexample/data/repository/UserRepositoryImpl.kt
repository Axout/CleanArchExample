package com.example.cleanarchexample.data.repository

 import com.example.cleanarchexample.data.storage.models.User
 import com.example.cleanarchexample.data.storage.UserStorage
import com.example.cleanarchexample.domain.models.SaveUserNameParam
import com.example.cleanarchexample.domain.models.UserName
import com.example.cleanarchexample.domain.repository.UserRepository

// В data-слое никакой логики! Здесь только сохраняем и получаем значения.
// Логика - в domain-слое.

class UserRepositoryImpl(private val userStorage: UserStorage): UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = User(
            firstName = saveParam.name,
            lastName = ""
        )
        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        val userName = UserName(
            firstName = user.firstName,
            lastName = user.lastName
        )
        return userName
    }
}
