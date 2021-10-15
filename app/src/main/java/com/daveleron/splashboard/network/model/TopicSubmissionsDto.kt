package com.daveleron.splashboard.network.model

import com.google.gson.annotations.SerializedName

data class TopicSubmissionsDto(
    @SerializedName("nature")
    val natureDto: NatureDto
)