package com.example.cleanarchexample.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchexample.domain.models.SaveUserNameParam
import com.example.cleanarchexample.domain.usecase.GetUserNameUseCase
import com.example.cleanarchexample.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase,
) : ViewModel() {

    private val resultLiveMutable = MutableLiveData<String>()
    val resultLiveData: LiveData<String> = resultLiveMutable


    fun save(text: String) {
        val params = SaveUserNameParam(text)
        val resultData: Boolean = saveUserNameUseCase.execute(params)
        resultLiveMutable.value = "Save result = $resultData"
    }

    fun load() {
        val userName = getUserNameUseCase.execute()
        resultLiveMutable.value = "${userName.firstName} ${userName.lastName}"
    }
}