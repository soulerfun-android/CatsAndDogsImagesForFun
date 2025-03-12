package com.example.lelele.presentation.MainActivity

import android.media.Image
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lelele.domain.GetCatImageUseCase
import com.example.lelele.domain.GetDogImageUseCase
import com.example.lelele.domain.entities.ImageItem
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getDogImageUseCase: GetDogImageUseCase,
    private val getCatImageUseCase: GetCatImageUseCase
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


}