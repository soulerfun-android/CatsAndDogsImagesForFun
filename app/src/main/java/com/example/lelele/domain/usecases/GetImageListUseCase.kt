package com.example.lelele.domain.usecases

import androidx.lifecycle.LiveData
import com.example.lelele.domain.Repository
import com.example.lelele.domain.entities.ImageItem
import javax.inject.Inject

class GetImageListUseCase @Inject constructor(
    private val repository: Repository
) {
    fun getImageList(): LiveData<List<ImageItem>> {
        return repository.getImageList()
    }
}