package com.example.cleanarchexample.presentation

import android.app.Application
import com.example.cleanarchexample.BuildConfig
import com.example.cleanarchexample.di.AppComponent
import com.example.cleanarchexample.di.AppModule
import com.example.cleanarchexample.di.DaggerAppComponent
import timber.log.Timber

class MyApp: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        // Только один модуль создаём вручную, оставльные Dagger создаст сам.
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()
    }
}