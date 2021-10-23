package com.daveleron.splashboard.presentation.photodisplay

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daveleron.splashboard.R
import com.daveleron.splashboard.network.RetrofitClient
import com.daveleron.splashboard.network.model.PhotoDto
import com.daveleron.splashboard.network.pagination.UnsplashPhotoDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class PhotoDisplayFragment : Fragment() {

    private lateinit var mAdapter: PhotoAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_photodisplay,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView : RecyclerView = view.findViewById(R.id.rvUnsplashPhotos)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        mAdapter = PhotoAdapter(requireContext())
        recyclerView.adapter = mAdapter

        lifecycleScope.launch {
//            val dto : PhotoDto = RetrofitClient.retrofitService.getRandomPhoto("Bearer Be_ALAPZCvtX6Jcy5KJHxZONQUG2aMS4Lm4IidRdEUg")
//            val dto : List<PhotoDto> = RetrofitClient.retrofitService.getPhotoList("Bearer Be_ALAPZCvtX6Jcy5KJHxZONQUG2aMS4Lm4IidRdEUg",1)
            getListData().collectLatest {
                mAdapter.submitData(it)
            }
            Log.d("Hello", "Hello")
        }
    }

    private fun getListData(): Flow<PagingData<PhotoDto>>{
        return Pager (config = PagingConfig(pageSize = 1, maxSize = 5), pagingSourceFactory = {UnsplashPhotoDataSource(RetrofitClient.retrofitService)}).flow.cachedIn(lifecycleScope)
    }

}