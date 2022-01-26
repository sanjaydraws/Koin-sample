package com.sanjayprajapat.koinsample.module

import com.sanjayprajapat.koinsample.data.Car
import org.koin.dsl.module


val demoModule = module {

    // every time inject new instance created
    factory {
        Car()
    }

    // to create singleton
    single {
        Car()
    }
}