package com.example.lelele.presentation

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.transition.Visibility
import com.bumptech.glide.Glide
import com.example.lelele.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: MainViewModel

    private val component by lazy {
        (application as App).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        loadCatPicture()

        loadPicture()
        binding.changePicture.setOnClickListener {
            loadPicture()
        }

    }

    private fun loadCatPicture() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = viewModel.getCatImage()
            for (image in response) {
                Log.d("MainActivity", "Response ${image.url}")
            }
        }
    }

    private fun loadPicture() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = viewModel.getDogImage()
            runOnUiThread {
                setPicture(response.message)
            }
        }
    }

    private fun setPicture(pictureUrl: String) {
        Glide.with(this@MainActivity)
            .load(pictureUrl)
            .into(binding.imageView)
    }
}