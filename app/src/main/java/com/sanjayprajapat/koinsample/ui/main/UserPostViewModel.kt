package com.sanjayprajapat.koinsample.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sanjayprajapat.koinsample.Repository.UserPostsRepository
import com.sanjayprajapat.koinsample.api.models.AllPosts
import com.sanjayprajapat.koinsample.api.models.Resource
import kotlinx.coroutines.launch




class UserPostViewModel  (private val postsRepository: UserPostsRepository) : ViewModel() {

    private val _userPostResponse: MutableLiveData<Resource<AllPosts>> = MutableLiveData()
    val userPostResponse: MutableLiveData<Resource<AllPosts>> =_userPostResponse
    fun getPosts(){
        viewModelScope.launch {
            _userPostResponse.postValue(Resource.loading())
            val response = postsRepository.getPosts()
            _userPostResponse.postValue(response)

        }
    }



}






