package com.example.cleanarchexample.domain.usecase

import com.example.cleanarchexample.domain.models.SaveUserNameParam
import com.example.cleanarchexample.domain.repository.UserRepository
import javax.inject.Inject

class SaveUserNameUseCase @Inject constructor(
    val userRepository: UserRepository
) {

    // Use Case на вход должен принимать ОДИН параметр (в примере - param: SaveUserNameParam)
    fun execute(param: SaveUserNameParam): Boolean {
        // Пример реализации логики в domain слое.
        val oldUserName = userRepository.getName()
        if (oldUserName.firstName == param.name) return true

        return userRepository.saveName(param)
    }
}