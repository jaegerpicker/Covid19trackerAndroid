package com.jaegerpicker.covid19api

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import com.jaegerpicker.covid19api.di.networkModule
import com.jaegerpicker.covid19api.di.roomModule
import com.jaegerpicker.covid19api.di.viewModelModule
import com.jaegerpicker.covid19api.di.apiModule


open class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@MainApplication)
            modules(networkModule, apiModule, roomModule, viewModelModule)
        }
    }
}