package com.sanjayprajapat.koinsample.di

import com.sanjayprajapat.koinsample.viewmodel.MainViewModel
import com.sanjayprajapat.koinsample.viewmodel.Test
import com.sanjayprajapat.koinsample.viewmodel.TestImp
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module


val viewModelModule = module {
    factory {
        TestImp() } bind Test::class

    viewModel { MainViewModel(get()) }

}