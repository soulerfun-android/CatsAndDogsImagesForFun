package com.example.lelele.data.network

import com.example.lelele.data.network.apiservices.CatApiService
import com.example.lelele.data.network.apiservices.DogApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

object ApiFactory {

    private const val BASE_URL_DOG = "https://dog.ceo/api/breeds/image/"

    private val retrofitDog = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL_DOG)
        .build()

    val apiServiceDog = retrofitDog.create(DogApiService::class.java)


    private const val BASE_URL_CAT = "https://api.thecatapi.com/v1/images/"
    private val retrofitCat = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL_CAT)
        .build()

    val apiServiceCat = retrofitCat.create(CatApiService::class.java)

}