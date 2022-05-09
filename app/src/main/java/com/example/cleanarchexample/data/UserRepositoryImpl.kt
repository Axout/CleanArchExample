package com.example.cleanarchexample.data

import com.example.cleanarchexample.domain.models.SaveUserNameParam
import com.example.cleanarchexample.domain.models.UserName
import com.example.cleanarchexample.domain.repository.UserRepository

class UserRepositoryImpl: UserRepository {

    override fun saveName(saveParam:SaveUserNameParam): Boolean {
        return true
    }

    override fun getName(): UserName {
        return UserName("Sergei", "Rakov")
    }
}
