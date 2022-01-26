package com.sanjayprajapat.koinsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sanjayprajapat.koinsample.component.Component
import com.sanjayprajapat.koinsample.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class MainActivity : AppCompatActivity() {
    var binding:ActivityMainBinding? = null
    private val component:Component by inject()

//    private val car: Car by inject() /// not a better way create component than use

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding?.apply {
            setContentView(root)
            lifecycleOwner = this@MainActivity
            executePendingBindings()
        }

        component.car.getCar()
    }
}