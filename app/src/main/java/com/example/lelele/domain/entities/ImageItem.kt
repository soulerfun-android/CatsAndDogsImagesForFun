package com.example.lelele.domain.entities

sealed class ImageItem {
    data class DogImageItem(val item: DogImage) : ImageItem()
    data class CatImageItem(val item: CatImage) : ImageItem()
}