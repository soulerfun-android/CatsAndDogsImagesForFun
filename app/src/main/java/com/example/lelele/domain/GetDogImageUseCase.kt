package com.example.lelele.domain

import com.example.lelele.domain.entities.DogImage
import javax.inject.Inject

class GetDogImageUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend fun getDogImage(): DogImage {
        return repository.getDogImage()
    }
}