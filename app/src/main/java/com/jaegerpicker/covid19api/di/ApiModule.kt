package com.jaegerpicker.covid19api.di

import com.jaegerpicker.covid19api.data.remote.api.CovidInfo
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single(createdAtStart = false) {
        get<Retrofit>().create(CovidInfo::class.java)
    }
}