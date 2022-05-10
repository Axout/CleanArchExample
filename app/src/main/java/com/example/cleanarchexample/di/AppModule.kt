package com.example.cleanarchexample.di

import android.content.Context
import com.example.cleanarchexample.domain.usecase.GetUserNameUseCase
import com.example.cleanarchexample.domain.usecase.SaveUserNameUseCase
import com.example.cleanarchexample.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideMainViewModelFactory(
        getUserNameUseCase: GetUserNameUseCase,
        saveUserNameUseCase: SaveUserNameUseCase
    ): MainViewModelFactory {
        return MainViewModelFactory(getUserNameUseCase, saveUserNameUseCase)
    }
}