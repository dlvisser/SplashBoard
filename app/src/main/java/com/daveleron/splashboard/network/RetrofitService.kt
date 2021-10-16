package com.daveleron.splashboard.network

import com.daveleron.splashboard.network.model.PhotoDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RetrofitService {

    @GET("photos")
    suspend fun getPhotoList(
        @Header("Authorization") token: String,
        @Query("page") page: Int
    ): List<PhotoDto>

    @GET("photos/random")
    suspend fun getRandomPhoto(
        @Header("Authorization") token: String
//        @Query("id") id: Int
    ): PhotoDto

}