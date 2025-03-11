package com.example.lelele.domain

import javax.inject.Inject

class DeleteImageUseCase @Inject constructor(
    private val repository: Repository
) {
    fun deleteImage() {
        repository.deleteImage()
    }
}