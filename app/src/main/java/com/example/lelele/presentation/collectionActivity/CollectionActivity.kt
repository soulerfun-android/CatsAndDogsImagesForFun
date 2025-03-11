package com.example.lelele.presentation.collectionActivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.lelele.R
import com.example.lelele.databinding.ActivityCollectionBinding
import com.example.lelele.databinding.ActivityMainBinding
import com.example.lelele.domain.entities.DogImage
import com.example.lelele.presentation.adapter.CollectionAdapter

class CollectionActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityCollectionBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val adapter = CollectionAdapter()

        binding.recyclerView.adapter = adapter


        val items = listOf(
            DogImage("https://images.dog.ceo/breeds/pyrenees/n02111500_1787.jpg", ""),
            DogImage("https://images.dog.ceo/breeds/pyrenees/n02111500_1787.jpg", ""),
            DogImage("https://images.dog.ceo/breeds/pyrenees/n02111500_1787.jpg", ""),
            DogImage("https://images.dog.ceo/breeds/pyrenees/n02111500_1787.jpg", ""),
            DogImage("https://images.dog.ceo/breeds/pyrenees/n02111500_1787.jpg", ""),
            DogImage("https://images.dog.ceo/breeds/pyrenees/n02111500_1787.jpg", ""),
            DogImage("https://images.dog.ceo/breeds/pyrenees/n02111500_1787.jpg", ""),
            DogImage("https://images.dog.ceo/breeds/pyrenees/n02111500_1787.jpg", ""),
            DogImage("https://images.dog.ceo/breeds/pyrenees/n02111500_1787.jpg", ""),
            DogImage("https://images.dog.ceo/breeds/pyrenees/n02111500_1787.jpg", ""),
            DogImage("https://images.dog.ceo/breeds/pyrenees/n02111500_1787.jpg", ""),
            DogImage("https://images.dog.ceo/breeds/pyrenees/n02111500_1787.jpg", ""),
        )

        adapter.submitList(items)

        goToBackScreen()
    }


    private fun goToBackScreen() {
        binding.backButton.setOnClickListener {
            finish()
        }
    }


    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, CollectionActivity::class.java)
        }
    }
}