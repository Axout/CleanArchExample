package com.example.cleanarchexample.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cleanarchexample.R
import com.example.cleanarchexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding(ActivityMainBinding::bind)
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initUi()

    }

    private fun initUi() {

        viewModel = ViewModelProvider(this, MainViewModelFactory(this))[MainViewModel::class.java]

        // this - здесь определяет в каком методе осуществлять отписку
        // если подписка в onCreate(), то отписка в onDestroy()
        // если подписка в onResume(), то отписка в onPause()
        viewModel.resultLiveData.observe(this) {
            binding.tvData.text = it
        }

        with(binding) {
            btSaveData.setOnClickListener {
                val text = etData.text.toString()
                viewModel.save(text)
            }

            btGetData.setOnClickListener {
                viewModel.load()
            }
        }
    }
}