package com.example.lelele.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.lelele.data.network.ApiFactory
import com.example.lelele.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.changePicture.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val response = ApiFactory.apiService.getRandomDogImage()
                Log.d("MainActivity", response.toString())
                runOnUiThread {
                    loadPicture(response.message)
                }
            }
        }
    }

    private fun loadPicture(pictureUrl: String) {
        Glide.with(this@MainActivity)
            .load(pictureUrl)
            .into(binding.imageView)
    }
}