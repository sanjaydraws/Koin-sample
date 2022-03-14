package com.sanjayprajapat.koinsample.di

import com.sanjayprajapat.koinsample.api.requests.PostsService
import org.koin.dsl.module
import retrofit2.Retrofit


/**
 * Created by Sanjay Prajapat on 14/03/2022 11:54 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified
 * */
val apiModule = module {

    /**
     * provide service module
     * */
    single(createdAtStart = false) {
        get<Retrofit>().create(PostsService::class.java)
    }

}