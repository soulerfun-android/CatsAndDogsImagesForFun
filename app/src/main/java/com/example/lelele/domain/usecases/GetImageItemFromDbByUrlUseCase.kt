package com.example.lelele.domain.usecases

import androidx.lifecycle.LiveData
import com.example.lelele.domain.Repository
import com.example.lelele.domain.entities.ImageItem
import javax.inject.Inject

class GetImageItemFromDbByUrlUseCase @Inject constructor(
    private val repository: Repository
) {
    fun getImageItem(imageItemUrl: String): ImageItem {
        return repository.getImageItem(imageItemUrl)
    }
}