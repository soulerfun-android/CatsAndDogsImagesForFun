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
        val dogImageDto = ApiFactory.apiServiceDog.getRandomDogImage()
        return mapper.mapDtoToEntityDog(dogImageDto)
    }

    override suspend fun getCatImage(): List<CatImage> {
        val catImageDto = ApiFactory.apiServiceCat.getRandomCatImage()
        return mapper.mapDtoToEntityCat(catImageDto)
    }

    override fun deleteImage() {
        TODO("Not yet implemented")
    }

    override fun addImage() {
        TODO("Not yet implemented")
    }
}