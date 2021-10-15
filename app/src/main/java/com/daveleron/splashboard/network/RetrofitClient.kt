package com.daveleron.splashboard.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    const val BASE_URL = "https://api.unsplash.com/"

    val retrofitBuilder: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    val retrofitService: RetrofitService by lazy {
        retrofitBuilder
            .build()
            .create(RetrofitService::class.java)
    }
}