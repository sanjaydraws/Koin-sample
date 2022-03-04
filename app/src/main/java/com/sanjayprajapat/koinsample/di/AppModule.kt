package com.sanjayprajapat.koinsample.module

import com.sanjayprajapat.koinsample.component.Component
import com.sanjayprajapat.koinsample.data.Car
import com.sanjayprajapat.koinsample.data.Engine
import com.sanjayprajapat.koinsample.data.Wheel
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

    // to create singleton
//    single {
//        Car()
//    }
}