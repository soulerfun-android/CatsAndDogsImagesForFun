package com.example.lelele.domain

import com.example.lelele.domain.entities.ImageItem
import javax.inject.Inject

class GetDogImageUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend fun getDogImage(): ImageItem {
        return repository.getDogImage()
    }
}