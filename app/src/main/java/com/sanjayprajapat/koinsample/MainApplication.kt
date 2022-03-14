package com.sanjayprajapat.koinsample

import androidx.multidex.MultiDexApplication
import com.sanjayprajapat.koinsample.di.*
import com.sanjayprajapat.koinsample.module.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication:MultiDexApplication() {
    companion object {
        lateinit var instance: MainApplication
            private set
    }
    override fun onCreate() {
        super.onCreate()

        // first start Koin(to use)
       startKoin {
           androidLogger(Level.DEBUG)
           androidContext(this@MainApplication)
           //can keep list of modules
           modules(listOf(
               appModule,
               interfaceModule,
               viewModelModule,
               apiModule,
               repositoryModule,
               retrofitModule
           ))
//            modules(
//                demoModule
//            )
        }
    }
}