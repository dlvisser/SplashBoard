package com.daveleron.splashboard.network.model

import com.google.gson.annotations.SerializedName

data class LocationDto(
    val city: Any,
    val country: Any,
    val name: Any,
    @SerializedName("position")
    val positionDto: PositionDto,
    val title: Any
)