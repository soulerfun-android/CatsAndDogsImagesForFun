package com.example.lelele.domain

import androidx.lifecycle.LiveData
import com.example.lelele.domain.entities.CatImage
import com.example.lelele.domain.entities.DogImage
import com.example.lelele.domain.entities.ImageItem

interface Repository {
    suspend fun getDogImage(): DogImage

    suspend fun getCatImage(): List<CatImage>

    fun deleteImage(image: ImageItem)

    fun addImage(image: ImageItem)

    fun getImageList(): LiveData<List<ImageItem>>
}