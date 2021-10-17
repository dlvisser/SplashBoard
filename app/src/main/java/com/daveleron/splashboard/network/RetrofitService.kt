package com.daveleron.splashboard.network

import com.daveleron.splashboard.network.model.PhotoDto
import com.daveleron.splashboard.network.model.UserDto
import com.daveleron.splashboard.network.response.PhotoSearchResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RetrofitService {

    @GET("me")
    suspend fun getOwnProfile(
        @Header("Authorization") token: String
    ) : UserDto

    @GET("photos")
    suspend fun searchPhotos(
        @Header("Authorization") token: String,
        @Query("query") searchQuery: String
    ) : PhotoSearchResponse

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