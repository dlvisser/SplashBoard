package com.daveleron.splashboard.network.model

import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("accepted_tos")
    val acceptedTos: Boolean,
    val bio: Any,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("for_hire")
    val forHire: Boolean,
    val id: String,
    @SerializedName("instagram_username")
    val instagramUsername: String,
    @SerializedName("last_name")
    val lastName: String,
    val links: UserLinksDto,
    val location: String,
    val name: String,
    @SerializedName("portfolio_url")
    val portfolioUrl: Any,
    @SerializedName("profile_image")
    val profileImage: ProfileImageDto,
    val social: SocialDto,
    @SerializedName("total_collections")
    val totalCollections: Int,
    @SerializedName("total_likes")
    val totalLikes: Int,
    @SerializedName("total_photos")
    val totalPhotos: Int,
    @SerializedName("twitter_username")
    val twitterUsername: Any,
    @SerializedName("updated_at")
    val updatedAt: String,
    val username: String
)