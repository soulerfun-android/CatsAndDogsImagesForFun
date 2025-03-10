package com.example.lelele.data.repository

import com.example.lelele.data.mapper.Mapper
import com.example.lelele.data.network.ApiFactory
import com.example.lelele.domain.Repository
import com.example.lelele.domain.entities.CatImage
import com.example.lelele.domain.entities.DogImage
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val mapper: Mapper
) : Repository {
    override suspend fun getDogImage(): DogImage {
        val dogImageDto = ApiFactory.apiService.getRandomDogImage()
        return mapper.mapDtoToEntity(dogImageDto)
    }

    override fun getCatImage(): CatImage {
        TODO("Not yet implemented")
    }
}