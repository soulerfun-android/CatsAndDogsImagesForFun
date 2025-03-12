package com.example.lelele.presentation.adapter

import com.example.lelele.domain.entities.CatImage
import com.example.lelele.domain.entities.DogImage

sealed class ImageItem {
    data class DogImageItem(val item: DogImage) : ImageItem()
    data class CatImageItem(val item: CatImage) : ImageItem()
}