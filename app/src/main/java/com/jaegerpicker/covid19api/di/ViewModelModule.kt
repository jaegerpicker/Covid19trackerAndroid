package com.jaegerpicker.covid19api.di

import com.jaegerpicker.covid19api.ui.areas.AreasViewModel
import com.jaegerpicker.covid19api.ui.information.InformationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { AreasViewModel(get(), get()) }
    viewModel { InformationViewModel(get()) }
}