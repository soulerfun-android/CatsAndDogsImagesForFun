package com.example.lelele.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.lelele.R
import com.example.lelele.domain.entities.ImageItem

class CollectionAdapter : ListAdapter<ImageItem, CollectionViewHolder>(CollectionDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionViewHolder {
        val layout = R.layout.item_star_image
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        val viewHolder = CollectionViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: CollectionViewHolder, position: Int) {
        when (val image = getItem(position)) {
            is ImageItem.DogImageItem -> {
                Glide.with(holder.ivPicture.context)
                    .load(image.item.message)
                    .into(holder.ivPicture)
            }

            is ImageItem.CatImageItem -> {
                Glide.with(holder.ivPicture.context)
                    .load(image.item.url)
                    .into(holder.ivPicture)
            }
        }
    }
}