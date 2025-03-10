package com.example.lelele.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
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

    private var flag = true

    private val component by lazy {
        (application as App).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        loadDogPicture()
        changeTypeOfAnimal()
        changePicture()
    }

    private fun changePicture() {
        binding.changePicture.setOnClickListener {
            if (flag) {
                loadDogPicture()
            } else {
                loadCatPicture()
            }
        }
    }

    private fun changeTypeOfAnimal() {
        binding.changeTypeOfAnimalButton.setOnClickListener {
            if (flag) {
                binding.changeTypeOfAnimalButton.text = CAT
                flag = false
            } else {
                binding.changeTypeOfAnimalButton.text = DOG
                flag = true
            }
        }
    }


    private fun loadCatPicture() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = viewModel.getCatImage()
            for (image in response) {
                runOnUiThread {
                    setPicture(image.url)
                }
            }
        }
    }

    private fun loadDogPicture() {
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

    companion object {
        private const val DOG = "DOG"
        private const val CAT = "CAT"
    }
}