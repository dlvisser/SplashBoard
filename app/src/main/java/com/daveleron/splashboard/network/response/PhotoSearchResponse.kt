package com.daveleron.splashboard.network.response

import com.daveleron.splashboard.network.model.*
import com.google.gson.annotations.SerializedName

data class PhotoSearchResponse(
    val total : Int,
    @SerializedName("total_pages")
    val totalPages : Int,
    @SerializedName("results")
    val photoResults : List<PhotoDto>
)