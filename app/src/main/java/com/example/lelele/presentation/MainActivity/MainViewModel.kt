package com.example.lelele.presentation.MainActivity

import androidx.lifecycle.ViewModel
import com.example.lelele.domain.GetCatImageUseCase
import com.example.lelele.domain.GetDogImageUseCase
import com.example.lelele.domain.entities.CatImage
import com.example.lelele.domain.entities.DogImage
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getDogImageUseCase: GetDogImageUseCase,
    private val getCatImageUseCase: GetCatImageUseCase
) : ViewModel() {


    suspend fun getDogImage(): DogImage {
        return getDogImageUseCase.getDogImage()
    }

    suspend fun getCatImage(): List<CatImage> {
        return getCatImageUseCase.getCatImage()
    }

}