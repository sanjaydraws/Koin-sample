package com.sanjayprajapat.koinsample.di

import com.sanjayprajapat.koinsample.Repository.UserPostsRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


val repositoryModule = module {
    single {
        UserPostsRepository(androidApplication(), get(),get())
    }
}

