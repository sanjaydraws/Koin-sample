package com.sanjayprajapat.koinsample.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.sanjayprajapat.koinsample.api.models.Status
import com.sanjayprajapat.koinsample.component.Component
import com.sanjayprajapat.koinsample.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class MainActivity : AppCompatActivity() {

    companion object{
        const val TAG ="MainActivity"
    }
    var binding:ActivityMainBinding? = null
    private val component:Component by inject()

//    private val car: Car by inject() /// not a better way create component than use
    private val homeViewModel: UserPostViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding?.apply {
            setContentView(root)
            lifecycleOwner = this@MainActivity
            executePendingBindings()
        }

        component.car.getCar()
        component.main.getDemo()
        component.mainViewModel.getTest()


        homeViewModel.getPosts()

        homeViewModel.userPostResponse.observe(this, Observer {
            it?:return@Observer
            when(it.status){
                Status.ERROR ->{
                    Log.d(TAG, "onCreate: ${it.message}")
                }
                Status.SUCCESS ->{
                    Log.d(TAG, "onCreate: ${it.data}")
                }
                Status.LOADING ->{
                    Log.d(TAG, "onCreate: ${it.message}")
                }
            }
        })
    }
}