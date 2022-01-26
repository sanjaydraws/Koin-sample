package com.sanjayprajapat.koinsample.component

import com.sanjayprajapat.koinsample.data.Car
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.component.inject

@KoinApiExtension
class Component :KoinComponent{

    // lazily instantiated
    val car: Car by inject()

    // also another way
    // eagerly  // when application created will be available
    val car1:Car = get()


}