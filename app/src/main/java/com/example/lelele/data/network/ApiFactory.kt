package com.example.lelele.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private const val BASE_URL_DOG = "https://dog.ceo/api/breeds/image/"
    private const val BASE_URL_CAT = "https://api.thecatapi.com/v1/images/"

    private val retrofitDog = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL_DOG)
        .build()

    val apiServiceDog = retrofitDog.create(ApiService::class.java)

    private val retrofitCat = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL_CAT)
        .build()

    val apiServiceCat = retrofitCat.create(ApiService::class.java)

}