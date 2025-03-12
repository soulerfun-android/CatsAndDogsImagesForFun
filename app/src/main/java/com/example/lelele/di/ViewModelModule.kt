package com.example.lelele.di

import androidx.lifecycle.ViewModel
import com.example.lelele.presentation.MainActivity.MainViewModel
import com.example.lelele.presentation.collectionActivity.CollectionViewModel
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
    fun bindCollectionViewMode(viewModel: CollectionViewModel): ViewModel

}