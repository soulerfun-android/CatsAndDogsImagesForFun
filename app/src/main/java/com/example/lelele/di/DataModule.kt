package com.example.lelele.di

import com.example.lelele.data.network.ApiFactory
import com.example.lelele.data.network.apiservices.CatApiService
import com.example.lelele.data.network.apiservices.DogApiService
import com.example.lelele.data.repository.RepositoryImpl
import com.example.lelele.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindRepository(impl: RepositoryImpl): Repository

    companion object {
        @Provides
        @ApplicationScope
        fun provideApiServiceCat(): CatApiService {
            return ApiFactory.apiServiceCat
        }

        @Provides
        @ApplicationScope
        fun provideApiServiceDog(): DogApiService {
            return ApiFactory.apiServiceDog
        }
    }
}