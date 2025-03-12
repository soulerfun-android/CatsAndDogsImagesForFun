package com.example.lelele.data.network.model

import com.google.gson.annotations.SerializedName

data class DogImageDto(

    @SerializedName("message") var message: String,
    @SerializedName("status") var status: String

)
