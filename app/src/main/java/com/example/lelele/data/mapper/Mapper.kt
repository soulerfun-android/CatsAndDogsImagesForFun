package com.example.lelele.data.mapper

import com.example.lelele.data.network.model.DogImageDto
import com.example.lelele.domain.entities.DogImage
import javax.inject.Inject

class Mapper @Inject constructor() {
    fun mapDtoToEntity(dto: DogImageDto): DogImage {
        return DogImage(
            message = dto.message,
            status = dto.status
        )
    }
}