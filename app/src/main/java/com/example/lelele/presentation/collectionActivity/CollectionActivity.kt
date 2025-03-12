package com.example.lelele.presentation.collectionActivity

import android.content.Context
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.lelele.R
import com.example.lelele.databinding.ActivityCollectionBinding
import com.example.lelele.databinding.ActivityMainBinding
import com.example.lelele.domain.entities.CatImage
import com.example.lelele.domain.entities.DogImage
import com.example.lelele.presentation.adapter.CollectionAdapter
import com.example.lelele.presentation.adapter.ImageItem

class CollectionActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityCollectionBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        setupAdapter()
        goToBackScreen()


        val items = listOf(
            ImageItem.DogImageItem(
                DogImage(
                    "https://images.dog.ceo/breeds/bluetick/n02088632_3049.jpg",
                    ""
                )
            ),
            ImageItem.DogImageItem(
                DogImage(
                    "https://images.dog.ceo/breeds/spitz-japanese/beet-005.jpg",
                    ""
                )
            ),
            ImageItem.DogImageItem(
                DogImage(
                    "https://images.dog.ceo/breeds/tervuren/shadow_and_frisbee.jpg",
                    ""
                )
            ),
            ImageItem.CatImageItem(
                CatImage(
                    "2",
                    "https://cdn2.thecatapi.com/images/MjA4ODgxMw.jpg",
                    2,
                    3
                )
            ),
            ImageItem.CatImageItem(
                CatImage(
                    "3",
                    "https://cdn2.thecatapi.com/images/3on.gif",
                    2,
                    3
                )
            ),
            ImageItem.CatImageItem(
                CatImage(
                    "3",
                    "https://cdn2.thecatapi.com/images/853.gif",
                    2,
                    3
                )
            )
        )


        val adapter = CollectionAdapter()
        binding.recyclerView.adapter = adapter
        adapter.submitList(items)

    }


    private fun goToBackScreen() {
        binding.backButton.setOnClickListener {
            finish()
        }
    }

    private fun setupAdapter() {


    }


    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, CollectionActivity::class.java)
        }
    }
}