package com.example.lelele.domain.usecases

import com.example.lelele.domain.Repository
import com.example.lelele.domain.entities.ImageItem
import javax.inject.Inject

class DeleteImageUseCase @Inject constructor(
    private val repository: Repository
) {
    fun deleteImage(imageItem: ImageItem) {
        repository.deleteImage(imageItem)
    }
}