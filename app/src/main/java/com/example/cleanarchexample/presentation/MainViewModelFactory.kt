package com.example.cleanarchexample.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchexample.data.repository.UserRepositoryImpl
import com.example.cleanarchexample.data.storage.sharedpref.SharedPrefUserStorage
import com.example.cleanarchexample.domain.usecase.GetUserNameUseCase
import com.example.cleanarchexample.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    // LazyThreadSafetyMode.NONE - отключение многопоточности
    // by lazy - инициализация произойдёт только в тот момент, когда потребуется данный объект
    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(SharedPrefUserStorage(context))
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(userRepository)
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(userRepository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getUserNameUseCase, saveUserNameUseCase) as T
    }
}