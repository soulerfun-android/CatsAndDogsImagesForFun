package com.example.lelele.presentation.collectionActivity

import androidx.lifecycle.ViewModel
import com.example.lelele.domain.usecases.DeleteImageUseCase
import com.example.lelele.domain.usecases.GetImageListUseCase
import javax.inject.Inject

class CollectionViewModel @Inject constructor(
    private val deleteImageUseCase: DeleteImageUseCase,
    private val getImageListUseCase: GetImageListUseCase
) : ViewModel() {

    val imageItems = getImageListUseCase.getImageList()


}