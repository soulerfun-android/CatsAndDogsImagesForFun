package com.example.lelele.presentation.MainActivity

import android.media.Image
import androidx.lifecycle.ViewModel
import com.example.lelele.domain.GetCatImageUseCase
import com.example.lelele.domain.GetDogImageUseCase
import com.example.lelele.domain.entities.ImageItem
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getDogImageUseCase: GetDogImageUseCase,
    private val getCatImageUseCase: GetCatImageUseCase
) : ViewModel() {


    suspend fun getDogImage(): ImageItem {
        return getDogImageUseCase.getDogImage()
    }

    suspend fun getCatImage(): ImageItem {
        return getCatImageUseCase.getCatImage()
    }

}