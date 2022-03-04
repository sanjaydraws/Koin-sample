package com.sanjayprajapat.koinsample.viewmodel

import android.util.Log


interface Test{
    fun getTest()
}


class TestImp:Test{
    override fun getTest() {
        Log.d("Main", "getTest: This is Testing ")
    }
}