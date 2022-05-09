package com.example.cleanarchexample.domain.usecase

import com.example.cleanarchexample.domain.models.UserName

class GetUserNameUseCase {

    fun execute(): UserName {
        return UserName("Sergei", "Rakov")
    }
}