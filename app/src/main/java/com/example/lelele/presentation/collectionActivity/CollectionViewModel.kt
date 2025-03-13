package com.example.lelele.presentation.collectionActivity

import androidx.lifecycle.ViewModel
import com.example.lelele.domain.entities.ImageItem
import com.example.lelele.domain.usecases.DeleteImageUseCase
import com.example.lelele.domain.usecases.GetImageListUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

class CollectionViewModel @Inject constructor(
    private val deleteImageUseCase: DeleteImageUseCase,
    private val getImageListUseCase: GetImageListUseCase
) : ViewModel() {

    private val exceptionHandler =
        CoroutineExceptionHandler { _, _ ->

        }

    private val viewModelJob = SupervisorJob()

    private val scope = CoroutineScope(Dispatchers.IO + exceptionHandler + viewModelJob)

    val imageItems = getImageListUseCase.getImageList()

    fun deleteImage(idImage: Int) {
        scope.launch {
            deleteImageUseCase.deleteImage(idImage)
        }
    }
}