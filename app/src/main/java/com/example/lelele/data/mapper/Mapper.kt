package com.example.lelele.data.mapper

import com.example.lelele.data.database.ImageItemDbModel
import com.example.lelele.data.network.model.CatImageDto
import com.example.lelele.data.network.model.DogImageDto
import com.example.lelele.domain.entities.ImageItem
import javax.inject.Inject

class Mapper @Inject constructor() {
    fun mapDtoDogToEntity(dto: DogImageDto): ImageItem {
        return ImageItem(
            url = dto.message
        )
    }

    fun mapDtoCatToEntity(dto: List<CatImageDto>): ImageItem {
        val imageItem = ImageItem(url = "")
        for (item in dto) {
            imageItem.url = item.url
        }
        return imageItem
    }

    fun mapEntityToDbModel(imageItem: ImageItem): ImageItemDbModel {
        return ImageItemDbModel(id = imageItem.id, url = imageItem.url)
    }

    private fun mapDbModelToEntity(imageItem: ImageItemDbModel): ImageItem {
        return ImageItem(id = imageItem.id, url = imageItem.url)
    }

    fun mapListDbModelToListEntity(list: List<ImageItemDbModel>) = list.map {
        mapDbModelToEntity(it)
    }
}