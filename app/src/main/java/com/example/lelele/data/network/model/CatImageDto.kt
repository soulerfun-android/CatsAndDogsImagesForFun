package com.example.lelele.data.network.model

import com.google.gson.annotations.SerializedName

data class CatImageDto(

    @SerializedName("id") var id: String,
    @SerializedName("url") var url: String,
    @SerializedName("width") var width: Int,
    @SerializedName("height") var height: Int

)