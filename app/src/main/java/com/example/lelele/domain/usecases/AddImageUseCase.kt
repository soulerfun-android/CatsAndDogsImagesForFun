package com.example.lelele.domain.usecases

import com.example.lelele.domain.Repository
import com.example.lelele.domain.entities.ImageItem
import javax.inject.Inject

class AddImageUseCase @Inject constructor(
    private val repository: Repository
) {
    fun addImage(imageItem: ImageItem) {
        repository.addImage(imageItem)
    }

}