package com.example.cleanarchexample.domain.usecase

import com.example.cleanarchexample.domain.models.UserName
import com.example.cleanarchexample.domain.repository.UserRepository
import javax.inject.Inject

class GetUserNameUseCase @Inject constructor(
    val userRepository: UserRepository
) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}