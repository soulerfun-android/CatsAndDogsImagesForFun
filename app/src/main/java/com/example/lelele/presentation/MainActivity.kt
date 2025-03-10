package com.example.lelele.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.lelele.R
import com.example.lelele.data.network.ApiFactory
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        CoroutineScope(Dispatchers.IO).launch {
            val response = ApiFactory.apiService.getRandomDogImage()
            Log.d("MainActivity", response.toString())
            withContext(Dispatchers.Main) {
            }
        }
    }
}