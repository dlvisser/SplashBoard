package com.daveleron.splashboard.network

import com.daveleron.splashboard.network.model.PhotoDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RetrofitService {

//    @GET("search")
//    suspend fun search(
//        @Header("Authorization") token: String,
//        @Query("page") page: Int
//    ): RecipeSearchResponse

    @GET("photos/random")
    suspend fun getRandomPhoto(
        @Header("Authorization") token: String
//        @Query("id") id: Int
    ): PhotoDto

}