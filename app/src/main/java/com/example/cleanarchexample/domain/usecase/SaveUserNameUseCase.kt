package com.example.cleanarchexample.domain.usecase

import com.example.cleanarchexample.domain.models.SaveUserNameParam
import com.example.cleanarchexample.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {
        return userRepository.saveName(param)
    }
}