package com.example.lelele.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.lelele.R
import com.example.lelele.domain.entities.ImageItem
import kotlin.math.truncate

class CollectionAdapter : ListAdapter<ImageItem, CollectionViewHolder>(CollectionDiffCallback()) {

    var onImageItemClickListener: ((ImageItem) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionViewHolder {
        val layout = R.layout.item_star_image
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        val viewHolder = CollectionViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: CollectionViewHolder, position: Int) {
        val image = getItem(position)
        val binding = holder.ivPicture

        Glide.with(holder.ivPicture.context)
            .load(image.url)
            .into(holder.ivPicture)

        binding.setOnLongClickListener {
            onImageItemClickListener
            true
        }
    }
}