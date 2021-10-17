package com.daveleron.splashboard.network.model

import com.google.gson.annotations.SerializedName

data class FileLinksDto(
    val download: String,
    @SerializedName("download_location")
    val downloadLocation: String,
    val html: String,
    val self: String
)