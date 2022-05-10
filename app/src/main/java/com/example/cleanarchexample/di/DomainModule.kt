package com.example.cleanarchexample.di

import com.example.cleanarchexample.domain.repository.UserRepository
import com.example.cleanarchexample.domain.usecase.GetUserNameUseCase
import com.example.cleanarchexample.domain.usecase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetUserNameUseCase(userRepository: UserRepository): GetUserNameUseCase {
        return GetUserNameUseCase(userRepository)
    }

    @Provides
    fun provideSaveUserNameUseCase(userRepository: UserRepository): SaveUserNameUseCase {
        return SaveUserNameUseCase(userRepository)
    }
}