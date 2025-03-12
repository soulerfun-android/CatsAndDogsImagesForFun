package com.example.lelele.domain

import com.example.lelele.domain.entities.ImageItem
import javax.inject.Inject

class AddImageUseCase @Inject constructor(
    private val repository: Repository
) {
    fun addImage(imageItem: ImageItem) {
        repository.addImage(imageItem)
    }

}