package com.example.lelele.presentation.fullscreenactivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.lelele.R
import com.example.lelele.databinding.ActivityCollectionBinding
import com.example.lelele.databinding.ActivityFullScreenImageBinding

class FullScreenImageActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFullScreenImageBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.backButtonImage.setOnClickListener {
            finish()
        }

        Glide.with(this)
            .load(intent.getStringExtra(URL))
            .into(binding.ivFull)

    }

    companion object {

        const val URL = "URL"
        fun newIntent(context: Context, url: String): Intent {
            return Intent(context, FullScreenImageActivity::class.java).apply {
                putExtra(URL, url)
            }
        }
    }
}