package com.sanjayprajapat.koinsample.ui.main

import androidx.lifecycle.ViewModel
import com.sanjayprajapat.koinsample.viewmodel.Test

class MainViewModel constructor(private val test: Test): ViewModel() {


    fun getTest(){
        test.getTest()
    }

}