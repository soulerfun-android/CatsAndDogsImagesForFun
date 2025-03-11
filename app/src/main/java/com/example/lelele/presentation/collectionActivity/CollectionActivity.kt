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
import com.example.lelele.domain.entities.CatImage
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
        setupAdapter()
        goToBackScreen()
    }


    private fun goToBackScreen() {
        binding.backButton.setOnClickListener {
            finish()
        }
    }

    private fun setupAdapter() {
        val adapter = CollectionAdapter()
        binding.recyclerView.adapter = adapter
    }


    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, CollectionActivity::class.java)
        }
    }
}