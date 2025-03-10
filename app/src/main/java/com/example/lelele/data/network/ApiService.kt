package com.example.lelele.data.network

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("random")
    suspend fun getRandomDogImage(): DogImage

}