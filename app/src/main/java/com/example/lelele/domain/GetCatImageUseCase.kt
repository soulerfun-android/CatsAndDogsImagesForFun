package com.example.lelele.domain

import com.example.lelele.domain.entities.CatImage
import com.example.lelele.domain.entities.DogImage
import javax.inject.Inject

class GetCatImageUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend fun getCatImage(): List<CatImage> {
        return repository.getCatImage()
    }
}