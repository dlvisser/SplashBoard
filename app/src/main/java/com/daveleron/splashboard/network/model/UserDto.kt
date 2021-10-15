package com.daveleron.splashboard.network.model

import com.google.gson.annotations.SerializedName

data class UserDto(
    val accepted_tos: Boolean,
    val bio: String,
    val first_name: String,
    val for_hire: Boolean,
    val id: String,
    val instagram_username: String,
    val last_name: String,
    @SerializedName("links")
    val userLinks: UserLinksDto,
    val location: String,
    val name: String,
    val portfolio_url: String,
    @SerializedName("profile_image")
    val profile_imageDto: ProfileImageDto,
    @SerializedName("social")
    val socialDto: SocialDto,
    val total_collections: Int,
    val total_likes: Int,
    val total_photos: Int,
    val twitter_username: Any,
    val updated_at: String,
    val username: String
)