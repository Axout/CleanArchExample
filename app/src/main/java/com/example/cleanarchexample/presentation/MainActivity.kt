package com.example.cleanarchexample.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cleanarchexample.R
import com.example.cleanarchexample.databinding.ActivityMainBinding
import com.example.cleanarchexample.domain.models.SaveUserNameParam
import com.example.cleanarchexample.domain.usecase.GetUserNameUseCase
import com.example.cleanarchexample.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding(ActivityMainBinding::bind)
    private val getUserNameUseCase = GetUserNameUseCase()
    private val saveUserNameUseCase = SaveUserNameUseCase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.initUi()

    }

    private fun ActivityMainBinding.initUi() {
        btSaveData.setOnClickListener {
            val text = etData.toString()
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