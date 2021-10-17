package com.daveleron.splashboard.presentation.photodisplay

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daveleron.splashboard.R
import com.daveleron.splashboard.network.RetrofitClient
import com.daveleron.splashboard.network.model.PhotoDto
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
            val dto : List<PhotoDto> = RetrofitClient.retrofitService.getPhotoList("Bearer Be_ALAPZCvtX6Jcy5KJHxZONQUG2aMS4Lm4IidRdEUg",1)
            Log.d("Hello", "Hello")
            mAdapter.setListOfPhotos(dto)
        }
    }

}