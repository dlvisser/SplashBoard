package com.daveleron.splashboard.network.model

import com.google.gson.annotations.SerializedName

data class PhotoDto(

    @SerializedName("id")
    var id: String,

    @SerializedName("description")
    var description: String,
)