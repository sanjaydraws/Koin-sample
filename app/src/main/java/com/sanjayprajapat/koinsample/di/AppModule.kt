package com.sanjayprajapat.koinsample.module

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.sanjayprajapat.koinsample.Constants.MY_SHARED_PREF
import com.sanjayprajapat.koinsample.component.Component
import com.sanjayprajapat.koinsample.data.Car
import com.sanjayprajapat.koinsample.data.Engine
import com.sanjayprajapat.koinsample.data.Wheel
import com.sanjayprajapat.koinsample.utils.GsonHelper
import com.sanjayprajapat.koinsample.utils.SharedPreferencesHelper
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


val demoModule = module {

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


    single {
        Gson()
    }
    single {
        GsonHelper(get())
    }
    single {
        androidApplication().getSharedPreferences(
            MY_SHARED_PREF,
            Context.MODE_PRIVATE
        )
    }
    single {
        SharedPreferencesHelper(get (), get ())
    }
    // to create singleton
//    single {
//        Car()
//    }
}