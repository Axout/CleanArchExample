package com.example.cleanarchexample.domain.usecase

import com.example.cleanarchexample.domain.models.SaveUserNameParam
import com.example.cleanarchexample.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {
        // Пример реализации логики в domain слое.
        val oldUserName = userRepository.getName()
        if (oldUserName.firstName == param.name) return true

        return userRepository.saveName(param)
    }
}