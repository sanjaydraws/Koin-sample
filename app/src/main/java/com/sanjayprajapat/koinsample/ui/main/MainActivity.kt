package com.sanjayprajapat.koinsample.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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

        binding?.referesh?.setOnClickListener {
            homeViewModel.getPosts()
        }
        homeViewModel.getPosts()

        homeViewModel.userPostResponse.observe(this, Observer {
            it?:return@Observer
            binding?.progressCircular?.status = it.status
            when(it.status){
                Status.ERROR ->{
                    Toast.makeText(this, it.message ,Toast.LENGTH_LONG).show()
                }
                Status.SUCCESS ->{
                    val posts  = it.data?.allPosts
                    if (posts != null) {
                        for (post in posts) {
                            var content: String = ""
                            content += "Id: ${post.id} \n"
                            content += "UserId: ${post.userId} \n"
                            content += "Title: ${post.title} \n"
                            content += "Text: ${post.description} \n"
                            binding?.textViewResult?.append(content)
                        }
                    }
                }
                Status.LOADING ->{
                    Log.d(TAG, "onCreate: ${it.message}")
                }
            }
        })
    }
}