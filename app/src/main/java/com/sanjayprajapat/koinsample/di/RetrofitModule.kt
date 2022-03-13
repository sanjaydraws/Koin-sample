package com.sanjayprajapat.koinsample.di

import android.content.Context
import com.google.gson.GsonBuilder
import com.sanjayprajapat.koinsample.BuildConfig
import com.sanjayprajapat.koinsample.api.Apis
import com.sanjayprajapat.koinsample.utils.SharedPreferencesHelper
import okhttp3.*
import okhttp3.internal.cacheGet
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.scope.Scope
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * Created by Sanjay Prajapat on 14/03/2022 12:06 AM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified
 * */

private const val CONNECT_TIMEOUT = 15L
private const val WRITE_TIMEOUT = 15L
private const val READ_TIMEOUT = 15L



val RetrofitModule = module {
    single { Cache(androidApplication().cacheDir, 10L * 1024 * 1024) }
    single { GsonBuilder().create() }
    single { retrofitHttpClient(androidContext(),get()) }
//    single { retrofitBuilder() }
    single {
        Interceptor { chain ->
            chain.proceed( chain.request().newBuilder().apply {
                header("Accept", "application/json")
                //.addHeader("Interceptor-Header", "xyz")
                //.addHeader("Authorization", sharedPreferencesHelper.getLoginToken() ?:"")//login token
                //.addHeader("Language", "en")
            }.build())
        }
    }

}

private fun Scope.retrofitBuilder(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(Apis.API_URL)
        .addConverterFactory(GsonConverterFactory.create(get()))
        //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(get())
        .build()
}

private fun Scope.retrofitHttpClient( context: Context, sharedPreferencesHelper: SharedPreferencesHelper): OkHttpClient {
    val httpClient:OkHttpClient.Builder = OkHttpClient.Builder().apply {
        cache(get())
        connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
        writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        retryOnConnectionFailure(true)
        addInterceptor{
                it.proceed( it.request().newBuilder().apply {
                    header("Accept", "application/json")
                    //.addHeader("Interceptor-Header", "xyz")
                    //.addHeader("Authorization", sharedPreferencesHelper.getLoginToken() ?:"")//login token
                    //.addHeader("Language", "en")
                }.build())
        }
        addInterceptor(httpLoggingInterceptor())
        //  addInterceptor(
        //  ChuckerInterceptor.Builder(context).build())

    }
    return httpClient.build()
}


/**
 * log http request & response with logging interceptor
 * */
fun httpLoggingInterceptor(): HttpLoggingInterceptor {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return httpLoggingInterceptor
}


fun interceptor():HttpLoggingInterceptor{
   return HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.HEADERS
        }
        else {
            HttpLoggingInterceptor.Level.NONE
        }
    }
}