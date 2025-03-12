package com.example.lelele.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import androidx.lifecycle.switchMap
import com.example.lelele.data.database.ImageItemDbModel
import com.example.lelele.data.database.ImageListDao
import com.example.lelele.data.mapper.Mapper
import com.example.lelele.data.network.apiservices.CatApiService
import com.example.lelele.data.network.apiservices.DogApiService
import com.example.lelele.domain.Repository
import com.example.lelele.domain.entities.ImageItem
import javax.inject.Inject


class RepositoryImpl @Inject constructor(
    private val mapper: Mapper,
    private val dogApiService: DogApiService,
    private val catApiService: CatApiService,
    private val imageListDao: ImageListDao
) : Repository {
    override suspend fun getDogImage(): ImageItem {
        val dogImageDto = dogApiService.getRandomDogImage()
        return mapper.mapDtoDogToEntity(dogImageDto)
    }

    override suspend fun getCatImage(): ImageItem {
        val catImageDto = catApiService.getRandomCatImage()
        return mapper.mapDtoCatToEntity(catImageDto)
    }

    override fun deleteImage(image: ImageItem) {
        imageListDao.deleteImageItem(image.id)
    }

    override fun addImage(image: ImageItem) {
        imageListDao.addImageItem(mapper.mapEntityToDbModel(image))
    }

    override fun getImageList(): LiveData<List<ImageItem>> = imageListDao.getImageList().map {
        mapper.mapListDbModelToListEntity(it)
    }
}

