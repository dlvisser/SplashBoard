package com.daveleron.splashboard.network.model

data class ExifDataDto(
    val aperture: String,
    val exposure_time: String,
    val focal_length: String,
    val iso: Int,
    val make: String,
    val model: String
)