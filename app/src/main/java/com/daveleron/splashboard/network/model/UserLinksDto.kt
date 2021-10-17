package com.daveleron.splashboard.network.model

data class UserLinksDto(
    val followers: String,
    val following: String,
    val html: String,
    val likes: String,
    val photos: String,
    val portfolio: String,
    val self: String
)