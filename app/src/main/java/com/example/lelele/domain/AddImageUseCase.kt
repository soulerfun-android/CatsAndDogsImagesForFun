package com.example.lelele.domain

import javax.inject.Inject

class AddImageUseCase @Inject constructor(
    private val repository: Repository
) {
    fun addImage() {
        repository.addImage()
    }

}