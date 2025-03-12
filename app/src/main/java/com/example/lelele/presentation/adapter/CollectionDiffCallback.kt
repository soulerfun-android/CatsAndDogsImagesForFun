package com.example.lelele.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.lelele.domain.entities.ImageItem

class CollectionDiffCallback : DiffUtil.ItemCallback<ImageItem>() {

    override fun areItemsTheSame(oldItem: ImageItem, newItem: ImageItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ImageItem, newItem: ImageItem): Boolean {
        return oldItem == newItem
    }
}