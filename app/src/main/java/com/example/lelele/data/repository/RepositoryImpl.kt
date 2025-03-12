package com.example.lelele.data.repository

import androidx.lifecycle.LiveData
import com.example.lelele.data.mapper.Mapper
import com.example.lelele.data.network.apiservices.CatApiService
import com.example.lelele.data.network.apiservices.DogApiService
import com.example.lelele.domain.Repository
import com.example.lelele.domain.entities.CatImage
import com.example.lelele.domain.entities.DogImage
import com.example.lelele.domain.entities.ImageItem
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val mapper: Mapper,
    private val dogApiService: DogApiService,
    private val catApiService: CatApiService
) : Repository {
    override suspend fun getDogImage(): DogImage {
        val dogImageDto = dogApiService.getRandomDogImage()
        return mapper.mapDtoToEntityDog(dogImageDto)
    }

    override suspend fun getCatImage(): List<CatImage> {
        val catImageDto = catApiService.getRandomCatImage()
        return mapper.mapDtoToEntityCat(catImageDto)
    }

    override fun deleteImage(image: ImageItem) {
        TODO("Not yet implemented")
    }

    override fun addImage(image: ImageItem) {
        TODO("Not yet implemented")
    }

    override fun getImageList(): LiveData<List<ImageItem>> {
        TODO("Not yet implemented")
    }

}