package com.example.lelele.presentation.MainActivity

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.lelele.databinding.ActivityMainBinding
import com.example.lelele.presentation.App
import com.example.lelele.presentation.ViewModelFactory
import com.example.lelele.presentation.collectionActivity.CollectionActivity
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val exceptionHandler =
        CoroutineExceptionHandler { _, _ ->
            runOnUiThread {
                binding.imageView.setImageDrawable(null)
                binding.errorText.visibility = View.VISIBLE
                binding.starIv.visibility = View.INVISIBLE
            }
        }

    private val scope = CoroutineScope(Dispatchers.IO + exceptionHandler)

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var viewModel: MainViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var flag = true

    private val component by lazy {
        (application as App).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        setPortraitOrientation() // Activity умирает при переворотах
        changeTypeOfAnimal()
        loadDogPicture()
        changePicture()
        launchCollectionScreen()

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
        scope.launch {
            val response = viewModel.getCatImage()
            runOnUiThread {
                setPicture(response.url)
            }
        }
    }

    private fun loadDogPicture() {
        scope.launch {
            val response = viewModel.getDogImage()
            runOnUiThread {
                setPicture(response.url)
            }
        }

    }

    private fun setPicture(pictureUrl: String) {
        Glide.with(this@MainActivity)
            .load(pictureUrl)
            .into(binding.imageView)
    }

    private fun setPortraitOrientation() {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    private fun launchCollectionScreen() {
        binding.collectionButton.setOnClickListener {
            val intent = CollectionActivity.newIntent(this)
            startActivity(intent)
        }
    }


    companion object {
        private const val DOG = "DOG"
        private const val CAT = "CAT"
    }
}