package com.sanjayprajapat.koinsample.Repository

import android.content.Context
import com.sanjayprajapat.koinsample.R
import com.sanjayprajapat.koinsample.api.models.AllPosts
import com.sanjayprajapat.koinsample.api.models.Resource
import com.sanjayprajapat.koinsample.api.requests.PostsService
import com.sanjayprajapat.koinsample.utils.GsonHelper
import com.sanjayprajapat.koinsample.utils.isConnectedToInternet


class UserPostsRepository constructor( val context: Context?, private val apiService: PostsService
                                              , private val gson: GsonHelper
) {

    val params: HashMap<String, String?> by lazy {
        HashMap<String, String?>()
    }

//    suspend fun getPosts(
//    ): Resource<AllPosts> {
//
//        if (isConnectedToInternet(context = context) != true) {
//            return Resource.error(data = null, context?.getString(R.string.no_internet_connected))
//        }
//        try {
//            val response = apiService.getPosts()
//            if (response?.isSuccessful == false) {
//                return Resource.error(
//                    data = null,
//                    context?.getString(R.string.default_error_message)
//                )
//            }
//            if (response?.body()?.status == 200) {
//                val posts  = Gson().fromJson(response.body()?.data, AllPosts::class.java)
//                return Resource.success(data = posts)
//            } else if (response?.body()?.status == 400) {
//                return Resource.error(message = response.body()?.message)
//            }
//            return Resource.error( message = response?.body()?.message?: context?.getString(R.string.default_error_message))
//        } catch (e: Exception) {
//            e.printStackTrace()
//            return Resource.error(data = null, context?.getString(R.string.default_error_message))
//        }
//    }


    suspend fun getPosts(
    ): Resource<AllPosts> {

        if (isConnectedToInternet(context = context) != true) {
            return Resource.error(data = null, context?.getString(R.string.no_internet_connected))
        }
        try {
            val response = apiService.getPosts()
            if (response?.isSuccessful == false) {
                return Resource.error(
                    data = null,
                    context?.getString(R.string.default_error_message)
                )
            }
            if (response?.code() == 200) {
                val posts  = gson.convertFromJson(response.body().toString(),AllPosts::class.java)
                return Resource.success(data = posts)
            } else if (response?.code() == 400) {
                return Resource.error(message = response.message()?:context?.getString(R.string.default_error_message))
            }
            return Resource.error( message = response?.message()?: context?.getString(R.string.default_error_message))
        } catch (e: Exception) {
            e.printStackTrace()
            return Resource.error(data = null, context?.getString(R.string.default_error_message))
        }
    }
}


