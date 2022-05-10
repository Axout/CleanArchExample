package com.example.cleanarchexample.di

import com.example.cleanarchexample.presentation.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}