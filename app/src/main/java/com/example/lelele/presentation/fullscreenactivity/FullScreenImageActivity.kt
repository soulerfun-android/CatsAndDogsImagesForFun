package com.example.lelele.presentation.fullscreenactivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.lelele.databinding.ActivityFullScreenImageBinding
import com.example.lelele.presentation.App
import com.example.lelele.presentation.ViewModelFactory
import javax.inject.Inject

class FullScreenImageActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFullScreenImageBinding.inflate(layoutInflater)
    }

    private lateinit var viewModel: FullScreenImageViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (application as App).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        viewModel =
            ViewModelProvider(this, viewModelFactory).get(FullScreenImageViewModel::class.java)

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