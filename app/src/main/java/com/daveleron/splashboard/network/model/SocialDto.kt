package com.daveleron.splashboard.network.model

import com.google.gson.annotations.SerializedName

data class SocialDto(
    @SerializedName("instagram_username")
    val instagramUsername: String,
    @SerializedName("paypal_email")
    val paypalEmail: Any,
    @SerializedName("portfolio_url")
    val portfolioUrl: String,
    @SerializedName("twitter_username")
    val twitterUsername: String
)