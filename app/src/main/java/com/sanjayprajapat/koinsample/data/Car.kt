package com.sanjayprajapat.koinsample.data

import android.util.Log

class Car constructor(private val engine: Engine, private val wheel: Wheel){

    companion object{
        const val TAG ="Car"
    }
    fun getCar(){
        wheel.getWheel()
        engine.getEngine()

        Log.d(TAG, "getCar: Car is Running")
    }
}

class Engine {

    companion object{
        const val TAG ="Engine"
    }
    fun getEngine(){
        Log.d(TAG, "Engine started")
    }
}


class Wheel {

    companion object{
        const val TAG ="Wheel"
    }
    fun getWheel(){
        Log.d(TAG, "Wheel started")
    }
}