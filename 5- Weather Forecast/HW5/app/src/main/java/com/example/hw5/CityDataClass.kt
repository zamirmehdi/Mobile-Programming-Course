package com.example.hw5

import com.google.gson.annotations.SerializedName

data class CityDataClass(
    @SerializedName("name")
    var name: String,
)
