package com.jaegerpicker.covid19api.di

import com.jaegerpicker.covid19api.data.db.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val roomModule = module {
    single { AppDatabase.getInstance(androidApplication()) }
    single(createdAtStart = false) {get<AppDatabase>().getInformationDao()}
}