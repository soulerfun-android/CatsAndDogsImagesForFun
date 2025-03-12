package com.example.lelele.presentation.adapter

import androidx.recyclerview.widget.DiffUtil

class CollectionDiffCallback : DiffUtil.ItemCallback<ImageItem>() {

    override fun areItemsTheSame(oldItem: ImageItem, newItem: ImageItem): Boolean {
        return when {
            oldItem is ImageItem.DogImageItem && newItem is ImageItem.DogImageItem
                -> oldItem.item.message == newItem.item.message

            oldItem is ImageItem.CatImageItem && newItem is ImageItem.CatImageItem
                -> oldItem.item.id == newItem.item.id

            else -> false
        }
    }

    override fun areContentsTheSame(oldItem: ImageItem, newItem: ImageItem): Boolean {
        return oldItem == newItem
    }
}