package com.example.hw5

import com.google.gson.annotations.SerializedName

data class WeatherDataClass(
    @SerializedName("description")
    var description: String,
    @SerializedName("icon")
    var icon: String,
)
