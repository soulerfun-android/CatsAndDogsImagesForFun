package com.example.lelele.domain

import androidx.lifecycle.LiveData
import com.example.lelele.domain.entities.ImageItem

interface Repository {
    suspend fun getDogImage(): ImageItem

    suspend fun getCatImage(): ImageItem

    fun deleteImage(imageId: Int)

    fun addImage(image: ImageItem)

    fun getImageList(): LiveData<List<ImageItem>>
}