package com.example.lelele.presentation.MainActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lelele.domain.entities.ImageItem
import com.example.lelele.domain.usecases.AddImageUseCase
import com.example.lelele.domain.usecases.DeleteImageUseCase
import com.example.lelele.domain.usecases.GetCatImageUseCase
import com.example.lelele.domain.usecases.GetDogImageUseCase
import com.example.lelele.domain.usecases.GetImageItemFromDbByUrlUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getDogImageUseCase: GetDogImageUseCase,
    private val getCatImageUseCase: GetCatImageUseCase,
    private val addImageUseCase: AddImageUseCase,
    private val deleteImageUseCase: DeleteImageUseCase,
    private val getImageItemFromDbByUrlUseCase: GetImageItemFromDbByUrlUseCase

) : ViewModel() {

    private val exceptionHandler =
        CoroutineExceptionHandler { _, _ ->
            _exceptionLD.postValue(true)
        }

    private val viewModelJob = SupervisorJob()

    private val scope = CoroutineScope(Dispatchers.IO + exceptionHandler + viewModelJob)

    private var _imageLD = MutableLiveData<ImageItem>()
    val imageLD: LiveData<ImageItem>
        get() = _imageLD

    private var _exceptionLD = MutableLiveData<Boolean>()
    val exceptionLD: LiveData<Boolean>
        get() = _exceptionLD


    private var _testLd = MutableLiveData<ImageItem>()
    val testLd: LiveData<ImageItem>
        get() = _testLd


    fun getDogImage() {
        scope.launch {
            _imageLD.postValue(getDogImageUseCase.getDogImage())
            _exceptionLD.postValue(false)
        }
    }

    fun getCatImage() {
        scope.launch {
            _imageLD.postValue(getCatImageUseCase.getCatImage())
            _exceptionLD.postValue(false)
        }
    }

    fun addImage(imageItem: ImageItem) {
        scope.launch {
            addImageUseCase.addImage(imageItem)
            _testLd.postValue(getImageItemFromDbByUrlUseCase.getImageItem(imageItem.url))
        }
    }

    fun deleteImage(imageId: Int) {
        scope.launch {
            deleteImageUseCase.deleteImage(imageId)
        }
    }

    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }
}