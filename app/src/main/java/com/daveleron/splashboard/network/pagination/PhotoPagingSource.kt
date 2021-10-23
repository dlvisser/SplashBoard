package com.daveleron.splashboard.network.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.daveleron.splashboard.network.RetrofitService
import com.daveleron.splashboard.network.model.PhotoDto
import com.daveleron.splashboard.utils.TMDB_STARTING_PAGE_INDEX
import retrofit2.HttpException
import java.io.IOException

class PhotoPagingSource(private val service: RetrofitService
    ) : PagingSource<Int, PhotoDto>()
{
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PhotoDto> {
        val pageIndex = params.key ?: TMDB_STARTING_PAGE_INDEX
        return try {
            val response = service.getPhotoList(
                "Bearer Be_ALAPZCvtX6Jcy5KJHxZONQUG2aMS4Lm4IidRdEUg",
                page = pageIndex
            )
            val nextKey =
                if (response.isEmpty()) {
                    null
                } else {
                    // By default, initial load size = 3 * NETWORK PAGE SIZE
                    // ensure we're not requesting duplicating items at the 2nd request
//                    pageIndex + (params.loadSize / NETWORK_PAGE_SIZE)
                    pageIndex + 1
                }
            LoadResult.Page(
                data = response,
                prevKey = if (pageIndex == TMDB_STARTING_PAGE_INDEX) null else pageIndex,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    /**
     * The refresh key is used for subsequent calls to PagingSource.Load after the initial load.
     */
    override fun getRefreshKey(state: PagingState<Int, PhotoDto>): Int? {
        // We need to get the previous key (or next key if previous is null) of the page
        // that was closest to the most recently accessed index.
        // Anchor position is the most recently accessed index.
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
