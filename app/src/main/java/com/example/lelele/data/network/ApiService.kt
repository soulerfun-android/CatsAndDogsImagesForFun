package com.example.lelele.data.network

import com.example.lelele.data.network.model.CatImageDto
import com.example.lelele.data.network.model.DogImageDto
import retrofit2.http.GET

interface ApiService {

    @GET("random")
    suspend fun getRandomDogImage(): DogImageDto

    @GET("search")
    suspend fun getRandomCatImage(): List<CatImageDto>

}