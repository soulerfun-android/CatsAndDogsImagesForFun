package com.example.lelele.domain

import com.example.lelele.domain.entities.CatImage
import com.example.lelele.domain.entities.DogImage

interface Repository {
    suspend fun getDogImage(): DogImage

    suspend fun getCatImage(): List<CatImage>
}