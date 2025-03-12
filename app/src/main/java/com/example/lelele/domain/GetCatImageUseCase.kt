package com.example.lelele.domain

import com.example.lelele.domain.entities.ImageItem
import javax.inject.Inject

class GetCatImageUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend fun getCatImage(): ImageItem {
        return repository.getCatImage()
    }
}