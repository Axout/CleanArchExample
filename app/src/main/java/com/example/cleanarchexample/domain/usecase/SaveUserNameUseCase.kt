package com.example.cleanarchexample.domain.usecase

import com.example.cleanarchexample.domain.models.SaveUserNameParam

class SaveUserNameUseCase {

    fun execute(param: SaveUserNameParam) : Boolean = param.name.isEmpty()
}