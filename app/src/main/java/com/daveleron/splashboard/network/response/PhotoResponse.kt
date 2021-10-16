package com.daveleron.splashboard.network.response

import com.daveleron.splashboard.network.model.*

data class PhotoResponse(
    val alt_description: Any,
    val blur_hash: String,
    val categories: List<Any>,
    val color: String,
    val created_at: String,
    val current_user_collections: List<Any>,
    val description: String,
    val downloads: Int,
    val exif: ExifDataDto,
    val height: Int,
    val id: String,
    val liked_by_user: Boolean,
    val likes: Int,
    val fileLinksDto: FileLinksDto,
    val location: LocationDto,
    val promoted_at: String,
    val sponsorship: Any,
    val updated_at: String,
    val urlsObjectDto: UrlsObjectDto,
    val userDto: UserDto,
    val views: Int,
    val width: Int
)