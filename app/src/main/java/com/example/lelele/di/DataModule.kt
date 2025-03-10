package com.example.lelele.di

import com.example.lelele.data.repository.RepositoryImpl
import com.example.lelele.domain.Repository
import dagger.Binds
import dagger.Module


@Module
interface DataModule {

    @Binds
    fun bindRepository(impl: RepositoryImpl): Repository
}