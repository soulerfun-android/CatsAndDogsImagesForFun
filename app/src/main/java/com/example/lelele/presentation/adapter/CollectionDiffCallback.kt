package com.example.lelele.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.lelele.domain.entities.DogImage

class CollectionDiffCallback : DiffUtil.ItemCallback<DogImage>() {
    override fun areItemsTheSame(oldItem: DogImage, newItem: DogImage): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: DogImage, newItem: DogImage): Boolean {
        return oldItem.message == newItem.message
    }
}