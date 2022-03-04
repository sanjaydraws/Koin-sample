package com.sanjayprajapat.koinsample.data

import android.util.Log

interface DemoOne{
    fun getDemoOne()
}
interface DemoTwo{
    fun getDemoTwo()
}

class DemoImpl():DemoOne,DemoTwo{
    override fun getDemoOne() {
        Log.d("DEMO_", "getDemoOne: this is demo one ")
    }

    override fun getDemoTwo() {
        Log.d("DEMO_", "getDemoTwo: this is demo two ")
    }
}

class Main(private val demoOne:DemoOne,private val demoTwo: DemoTwo){
    fun getDemo(){
        demoOne.getDemoOne()
        demoTwo.getDemoTwo()
    }
}