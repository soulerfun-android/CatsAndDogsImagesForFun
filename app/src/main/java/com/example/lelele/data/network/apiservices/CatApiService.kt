package com.example.lelele.data.network.apiservices

import com.example.lelele.data.network.model.CatImageDto
import retrofit2.http.GET

interface CatApiService {
    @GET("search")
    suspend fun getRandomCatImage(): List<CatImageDto>
}