package com.sanjayprajapat.koinsample

import android.app.Application
import com.sanjayprajapat.koinsample.di.interfaceModule
import com.sanjayprajapat.koinsample.module.demoModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication:Application() {

    override fun onCreate() {
        super.onCreate()

        // first start Koin(to use)
       startKoin {
           //can keep list of modules
           modules(listOf(demoModule,interfaceModule))
//            modules(
//                demoModule
//            )
        }
    }
}