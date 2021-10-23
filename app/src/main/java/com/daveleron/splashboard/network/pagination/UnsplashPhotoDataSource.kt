package com.daveleron.splashboard.network.pagination

import androidx.paging.*
import com.daveleron.splashboard.network.RetrofitService
import com.daveleron.splashboard.network.model.PhotoDto
import kotlinx.coroutines.flow.Flow

const val NETWORK_PAGE_SIZE = 25

class UnsplashPhotoDataSource(private val photoService: RetrofitService) : PagingSource<Int, PhotoDto>() {
    override fun getRefreshKey(state: PagingState<Int, PhotoDto>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PhotoDto> {
        return try {
            val nextPage : Int = params.key ?: 1
            val response = photoService.getPhotoList("Bearer Be_ALAPZCvtX6Jcy5KJHxZONQUG2aMS4Lm4IidRdEUg",nextPage)

            LoadResult.Page(data = response, prevKey = null, nextKey = if(response.isEmpty()) null else nextPage+1)

        }catch (e : Exception){
            LoadResult.Error(e)
        }
    }
}