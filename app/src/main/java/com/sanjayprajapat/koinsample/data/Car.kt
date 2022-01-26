package com.sanjayprajapat.koinsample.data

import android.util.Log

class Car {

    companion object{
        const val TAG ="Car"
    }
    fun getCar(){
        Log.d(TAG, "getCar: Car is Running")
    }
}