package com.sanjayprajapat.koinsample.api

import android.content.Context
import com.sanjayprajapat.koinsample.utils.isConnectedToInternet
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class NetworkConnectionInterceptor(val context: Context) :Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if(isConnectedToInternet(context = context) != true){
            throw NoConnectivityException(context)
        }else{
            val builder: Request.Builder = chain.request().newBuilder()
            return chain.proceed(builder.build())
        }
    }
}