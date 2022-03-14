package com.sanjayprajapat.koinsample.di

import com.sanjayprajapat.koinsample.ui.main.MainViewModel
import com.sanjayprajapat.koinsample.ui.main.UserPostViewModel
import com.sanjayprajapat.koinsample.viewmodel.Test
import com.sanjayprajapat.koinsample.viewmodel.TestImp
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 *  provide view module
 * */
val viewModelModule = module {
    factory {
        TestImp() } bind Test::class

    viewModel { MainViewModel(get()) }
    viewModel {
        UserPostViewModel(get())
    }

}