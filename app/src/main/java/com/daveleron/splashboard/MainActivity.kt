package com.daveleron.splashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.daveleron.splashboard.network.RetrofitClient
import com.daveleron.splashboard.network.model.PhotoDto
import com.unsplash.pickerandroid.example.PhotoAdapter
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var mAdapter: PhotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val recyclerView : RecyclerView = findViewById(R.id.rvUnsplashPhotos)
        recyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter = PhotoAdapter(this)
        recyclerView.adapter = mAdapter

        lifecycleScope.launch {
//            val dto : PhotoDto = RetrofitClient.retrofitService.getRandomPhoto("Bearer Be_ALAPZCvtX6Jcy5KJHxZONQUG2aMS4Lm4IidRdEUg")
            val dto : List<PhotoDto> = RetrofitClient.retrofitService.getPhotoList("Bearer Be_ALAPZCvtX6Jcy5KJHxZONQUG2aMS4Lm4IidRdEUg",1)
            mAdapter.setListOfPhotos(dto)



        }
    }
}