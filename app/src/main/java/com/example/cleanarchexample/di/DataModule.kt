package com.example.cleanarchexample.di

import android.content.Context
import com.example.cleanarchexample.data.repository.UserRepositoryImpl
import com.example.cleanarchexample.data.storage.UserStorage
import com.example.cleanarchexample.data.storage.sharedpref.SharedPrefUserStorage
import com.example.cleanarchexample.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideUserStorage(context: Context): UserStorage {
        return SharedPrefUserStorage(context)
    }

    @Provides
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage)
    }
}