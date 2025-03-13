package com.example.lelele.presentation.MainActivity

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.lelele.R
import com.example.lelele.databinding.ActivityMainBinding
import com.example.lelele.presentation.App
import com.example.lelele.presentation.ViewModelFactory
import com.example.lelele.presentation.collectionActivity.CollectionActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var viewModel: MainViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var flagCatOrDog = true

    private val component by lazy {
        (application as App).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        setPortraitOrientation() // Activity умирает при переворотах

        loadDogPicture()
        funLoadPictureWhenGetOne()

        changePicture()
        changeTypeOfAnimal()

        launchCollectionScreen()
        showError()

        colorStarAndAddImageInDb()

    }

    private fun colorStarAndAddImageInDb() {
        Glide.with(this)
            .load(android.R.drawable.btn_star_big_off)
            .into(binding.starIv)
        binding.starIv.setOnClickListener {
            Glide.with(this)
                .load(android.R.drawable.btn_star_big_on)
                .into(binding.starIv)
            viewModel.addImage(viewModel.imageLD.value!!)
            binding.starIv.setOnClickListener(null)
        }
    }


    private fun showError() {
        viewModel.exceptionLD.observe(this) {
            if (viewModel.exceptionLD.value ?: throw RuntimeException("Error in exception LD")) {
                binding.imageView.setImageDrawable(null)
                binding.errorText.visibility = View.VISIBLE
                binding.starIv.visibility = View.GONE
            } else {
                binding.errorText.visibility = View.INVISIBLE
                binding.starIv.visibility = View.VISIBLE
            }
        }
    }

    private fun changePicture() {
        binding.changePicture.setOnClickListener {
            if (flagCatOrDog) {
                loadDogPicture()
            } else {
                loadCatPicture()
            }
        }
    }

    private fun changeTypeOfAnimal() {
        binding.changeTypeOfAnimalButton.setOnClickListener {
            if (flagCatOrDog) {
                binding.changeTypeOfAnimalButton.text = CAT
                flagCatOrDog = false
            } else {
                binding.changeTypeOfAnimalButton.text = DOG
                flagCatOrDog = true
            }
        }
    }

    private fun loadCatPicture() {
        viewModel.getCatImage()
    }

    private fun loadDogPicture() {
        viewModel.getDogImage()
    }

    private fun funLoadPictureWhenGetOne() {
        viewModel.imageLD.observe(this) {
            val url = viewModel.imageLD.value?.url ?: throw RuntimeException("Url not found")
            setPicture(url)
            colorStarAndAddImageInDb()
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