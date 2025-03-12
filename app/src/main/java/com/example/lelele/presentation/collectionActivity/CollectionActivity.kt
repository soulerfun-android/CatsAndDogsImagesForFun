package com.example.lelele.presentation.collectionActivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.lelele.databinding.ActivityCollectionBinding
import com.example.lelele.presentation.App
import com.example.lelele.presentation.ViewModelFactory
import com.example.lelele.presentation.adapter.CollectionAdapter
import kotlinx.coroutines.launch
import javax.inject.Inject

class CollectionActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityCollectionBinding.inflate(layoutInflater)
    }

    private lateinit var adapter: CollectionAdapter

    private lateinit var viewModel: CollectionViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (application as App).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setupAdapter()
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, viewModelFactory).get(CollectionViewModel::class.java)
        viewModel.imageItems.observe(this) {
            adapter.submitList(it)
        }
        goToBackScreen()
        setupLongClickListener()

        setupSwipeListener(binding.recyclerView)
    }

    private fun goToBackScreen() {
        binding.backButton.setOnClickListener {
            finish()
        }
    }

    private fun setupAdapter() {
        adapter = CollectionAdapter()
        binding.recyclerView.adapter = adapter
    }

    private fun setupLongClickListener() {
        adapter.onImageItemLongClickListener = {
            Log.d("CollectionActivity", it.toString())
            viewModel.deleteImage(it)
        }
    }

    private fun setupSwipeListener(rv: RecyclerView) {
        val callback = object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val image = adapter.currentList[viewHolder.adapterPosition]
                viewModel.deleteImage(image)
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(rv)
    }


    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, CollectionActivity::class.java)
        }
    }
}