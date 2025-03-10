package com.example.lelele.data.mapper

import com.example.lelele.data.network.model.CatImageDto
import com.example.lelele.data.network.model.DogImageDto
import com.example.lelele.domain.entities.CatImage
import com.example.lelele.domain.entities.DogImage
import javax.inject.Inject

class Mapper @Inject constructor() {
    fun mapDtoToEntityDog(dto: DogImageDto): DogImage {
        return DogImage(
            message = dto.message,
            status = dto.status
        )
    }

    fun mapDtoToEntityCat(dto: List<CatImageDto>): List<CatImage> {
        var catImage = mutableListOf<CatImage>()
        for (item in dto) {
            catImage.add(CatImage(item.id, item.url, item.width, item.height))
        }
        return catImage
    }
}