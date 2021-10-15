package com.daveleron.splashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.lifecycle.lifecycleScope
import coil.load
import com.daveleron.splashboard.network.RetrofitClient
import com.daveleron.splashboard.network.model.PhotoDto
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        lifecycleScope.launch {
            val dto : PhotoDto = RetrofitClient.retrofitService.getRandomPhoto("Bearer Be_ALAPZCvtX6Jcy5KJHxZONQUG2aMS4Lm4IidRdEUg")
            val iv : ImageView = findViewById(R.id.ivPhoto)
            iv.load(dto.urlsObjectDto.full)
        }
    }
}