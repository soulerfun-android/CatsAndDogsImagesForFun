package com.example.lelele.presentation.MainActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lelele.domain.usecases.GetCatImageUseCase
import com.example.lelele.domain.usecases.GetDogImageUseCase
import com.example.lelele.domain.entities.ImageItem
import com.example.lelele.domain.usecases.AddImageUseCase
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
    private val addImageUseCase: AddImageUseCase
) : ViewModel() {

    private val exceptionHandler =
        CoroutineExceptionHandler { _, _ ->
            _exceptionLD.postValue(true)
        }

    private val viewModelJob = SupervisorJob()

    private val scope = CoroutineScope(Dispatchers.IO + exceptionHandler + viewModelJob)

    private var _catImageLD = MutableLiveData<ImageItem>()
    val catImageLD: LiveData<ImageItem>
        get() = _catImageLD

    private var _dogImageLD = MutableLiveData<ImageItem>()
    val dogImageLD: LiveData<ImageItem>
        get() = _dogImageLD

    private var _exceptionLD = MutableLiveData<Boolean>()
    val exceptionLD: LiveData<Boolean>
        get() = _exceptionLD


    fun getDogImage() {
        scope.launch {
            _dogImageLD.postValue(getDogImageUseCase.getDogImage())
            _exceptionLD.postValue(false)
        }
    }

    fun getCatImage() {
        scope.launch {
            _catImageLD.postValue(getCatImageUseCase.getCatImage())
            _exceptionLD.postValue(false)
        }
    }

    private fun addImage(imageItem: ImageItem) {
        addImageUseCase.addImage(imageItem)
    }

    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }
}