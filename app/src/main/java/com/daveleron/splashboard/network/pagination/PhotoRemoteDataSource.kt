package com.daveleron.splashboard.network.pagination

import androidx.paging.PagingData
import com.daveleron.splashboard.network.model.PhotoDto
import kotlinx.coroutines.flow.Flow

interface PhotoRemoteDataSource {
        fun getPhotos(): Flow<PagingData<PhotoDto>>
}
