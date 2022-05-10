package com.example.cleanarchexample.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchexample.domain.usecase.GetUserNameUseCase
import com.example.cleanarchexample.domain.usecase.SaveUserNameUseCase
import javax.inject.Inject


class MainViewModelFactory @Inject constructor(
    val getUserNameUseCase: GetUserNameUseCase,
    val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getUserNameUseCase, saveUserNameUseCase) as T
    }
}