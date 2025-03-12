package com.example.lelele.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "image_items")
data class ImageItemDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val url: String
)