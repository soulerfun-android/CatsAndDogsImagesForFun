package com.example.lelele.presentation.adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.lelele.R

class CollectionViewHolder(
    private val view: View
) : RecyclerView.ViewHolder(view) {
    val ivPicture = view.findViewById<ImageView>(R.id.iv_picture)
}