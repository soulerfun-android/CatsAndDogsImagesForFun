package com.example.lelele.domain.usecases

import androidx.lifecycle.LiveData
import com.example.lelele.domain.Repository
import com.example.lelele.domain.entities.ImageItem
import javax.inject.Inject

class GetImageItemUseCase @Inject constructor(
    private val repository: Repository
) {
    fun getImageItem(imageItemId: Int): ImageItem {
        return repository.getImageItem(imageItemId)
    }
}