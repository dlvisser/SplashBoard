package com.daveleron.splashboard.network.pagination

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.daveleron.splashboard.network.RetrofitService
import com.daveleron.splashboard.network.model.PhotoDto
import kotlinx.coroutines.flow.Flow

const val NETWORK_PAGE_SIZE = 25

internal class PhotoRemoteDataSourceImpl(
    private val movieService: RetrofitService
) : PhotoRemoteDataSource {

    override fun getPhotos(): Flow<PagingData<PhotoDto>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                PhotoPagingSource(service = movieService)
            }
        ).flow
    }
}