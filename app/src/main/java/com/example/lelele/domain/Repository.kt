package com.example.lelele.domain

import androidx.lifecycle.LiveData
import com.example.lelele.domain.entities.ImageItem

interface Repository {
    suspend fun getDogImage(): ImageItem

    suspend fun getCatImage(): ImageItem

    fun deleteImage(image: ImageItem)

    fun addImage(image: ImageItem)

    fun getImageItem(imageItemId: Int): ImageItem

    fun getImageList(): LiveData<List<ImageItem>>
}