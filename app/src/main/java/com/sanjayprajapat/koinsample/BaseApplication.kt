package com.sanjayprajapat.koinsample

import android.app.Application
import com.sanjayprajapat.koinsample.module.demoModule
import org.koin.core.context.startKoin

class BaseApplication:Application() {

    override fun onCreate() {
        super.onCreate()

        // first start Koin
        startKoin {
            //can keep list of modules
            modules(
                demoModule
            )
        }
    }
}