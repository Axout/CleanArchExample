package com.example.cleanarchexample.domain.repository

import com.example.cleanarchexample.domain.models.SaveUserNameParam
import com.example.cleanarchexample.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName
}