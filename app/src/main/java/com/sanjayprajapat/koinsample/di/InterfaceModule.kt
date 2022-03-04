package com.sanjayprajapat.koinsample.di

import com.sanjayprajapat.koinsample.data.DemoImpl
import com.sanjayprajapat.koinsample.data.DemoOne
import com.sanjayprajapat.koinsample.data.DemoTwo
import com.sanjayprajapat.koinsample.data.Main
import org.koin.dsl.bind
import org.koin.dsl.binds
import org.koin.dsl.module


val interfaceModule = module {

    // three way to provide interface dependency
//    factory {
//        DemoImpl() as? DemoOne
//    }  // not recommended

//    factory <DemoOne>{ DemoImpl() }

    // recommended way
//    factory { DemoImpl()  } bind DemoOne::class

    // if class implement more than one interface
    factory { DemoImpl() } binds  arrayOf(DemoOne::class, DemoTwo::class)

    factory { Main(get(), get()) }

}