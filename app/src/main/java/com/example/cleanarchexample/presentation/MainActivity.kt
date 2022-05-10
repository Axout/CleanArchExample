package com.example.cleanarchexample.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cleanarchexample.R
import com.example.cleanarchexample.data.repository.UserRepositoryImpl
import com.example.cleanarchexample.data.storage.sharedpref.SharedPrefUserStorage
import com.example.cleanarchexample.databinding.ActivityMainBinding
import com.example.cleanarchexample.domain.models.SaveUserNameParam
import com.example.cleanarchexample.domain.usecase.GetUserNameUseCase
import com.example.cleanarchexample.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding(ActivityMainBinding::bind)

    // LazyThreadSafetyMode.NONE - отключение многопоточности
    // by lazy - инициализация произойдёт только в тот момент, когда потребуется данный объект
    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(SharedPrefUserStorage(applicationContext))
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(userRepository)
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(userRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.initUi()

    }

    private fun ActivityMainBinding.initUi() {

        btSaveData.setOnClickListener {
            val text = etData.text.toString()
            val params = SaveUserNameParam(text)
            val result: Boolean = saveUserNameUseCase.execute(params)
            tvData.text = "Save result = $result"
        }

        btGetData.setOnClickListener {
            val userName = getUserNameUseCase.execute()
            tvData.text = "${userName.firstName} ${userName.lastName}"
        }
    }
}