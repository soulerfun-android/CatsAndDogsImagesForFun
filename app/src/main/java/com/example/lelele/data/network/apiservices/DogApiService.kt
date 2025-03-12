package com.example.lelele.data.network.apiservices

import com.example.lelele.data.network.model.DogImageDto
import retrofit2.http.GET

interface DogApiService {
    @GET("random")
    suspend fun getRandomDogImage(): DogImageDto
}