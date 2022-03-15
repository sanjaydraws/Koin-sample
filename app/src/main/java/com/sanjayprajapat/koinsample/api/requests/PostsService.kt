package com.sanjayprajapat.koinsample.api.requests

import com.sanjayprajapat.koinsample.api.models.AllPosts
import com.sanjayprajapat.koinsample.api.models.Posts
import retrofit2.Response
import retrofit2.http.GET


interface PostsService {

//    @GET("posts")
//     suspend fun getPosts(): Response<BaseApiModel>?


    @GET("posts")
    suspend fun getPosts(): Response<List<Posts>>?

}