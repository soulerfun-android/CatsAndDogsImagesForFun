package com.example.lelele.domain.usecases

import androidx.lifecycle.LiveData
import com.example.lelele.domain.Repository
import com.example.lelele.domain.entities.ImageItem
import javax.inject.Inject

class GetImageItemFromDbUseCase @Inject constructor(
    private val repository: Repository
) {
    fun getImageItemFromDb(imageId: Int): LiveData<ImageItem> {
        return repository.getImageItem(imageId)
    }
}