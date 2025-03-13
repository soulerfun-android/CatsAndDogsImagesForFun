package com.example.lelele.di

import androidx.lifecycle.ViewModel
import com.example.lelele.presentation.MainActivity.MainViewModel
import com.example.lelele.presentation.collectionActivity.CollectionViewModel
import com.example.lelele.presentation.fullscreenactivity.FullScreenImageViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CollectionViewModel::class)
    fun bindCollectionViewModel(viewModel: CollectionViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FullScreenImageViewModel::class)
    fun bindFullScreenImageViewModel(viewModel: FullScreenImageViewModel): ViewModel


}