package com.example.lelele.di

import androidx.lifecycle.ViewModel
import com.example.lelele.presentation.MainViewModel
import com.example.lelele.presentation.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel

}