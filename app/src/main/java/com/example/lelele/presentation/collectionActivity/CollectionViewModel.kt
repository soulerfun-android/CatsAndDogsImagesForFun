package com.example.lelele.presentation.collectionActivity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lelele.domain.entities.ImageItem
import com.example.lelele.domain.usecases.DeleteImageUseCase
import com.example.lelele.domain.usecases.GetImageListUseCase
import com.example.lelele.presentation.adapter.CollectionAdapter
import com.example.lelele.presentation.adapter.CollectionViewHolder
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

    fun deleteImage(imageItem: ImageItem) {
        scope.launch {
            deleteImageUseCase.deleteImage(imageItem)
        }
    }
}