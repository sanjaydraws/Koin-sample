package com.sanjayprajapat.koinsample.module

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.sanjayprajapat.koinsample.Constants.MY_SHARED_PREF
import com.sanjayprajapat.koinsample.api.requests.PostsService
import com.sanjayprajapat.koinsample.component.Component
import com.sanjayprajapat.koinsample.data.Car
import com.sanjayprajapat.koinsample.data.Engine
import com.sanjayprajapat.koinsample.data.Wheel
import com.sanjayprajapat.koinsample.utils.GsonHelper
import com.sanjayprajapat.koinsample.utils.SharedPreferencesHelper
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit



/**
 * Created by Sanjay Prajapat on 14/03/2022 11:43 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified
 * */
val appModule = module {
    /**
     * Provide singleton of Gson
     * */
    single {
        Gson()
    }

    /**
     * Provide singleton of Gson Helper
     * */
    single {
        GsonHelper(get())
    }

    /**
     * Provide singleton of SharedPreference
     * */
    single {
        androidApplication().getSharedPreferences(
            MY_SHARED_PREF,
            Context.MODE_PRIVATE
        )
    }

    /**
     * Provide singleton of SharedPreference Helper
     * */
    single {
        SharedPreferencesHelper(get (), get ())
    }

    single {
        Wheel()
    }

    single {
        Engine()
    }
    // every time inject new instance created
    single {
        Car(get(),get())
    }
    single {
        Component()
    }


}