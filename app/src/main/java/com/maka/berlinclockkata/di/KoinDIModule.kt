package com.maka.berlinclockkata.di

import com.maka.berlinclockkata.ui.TimeScreenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::TimeScreenViewModel)
}