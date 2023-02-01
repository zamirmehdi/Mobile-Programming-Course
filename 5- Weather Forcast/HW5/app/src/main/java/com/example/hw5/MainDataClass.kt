package com.example.hw5

import com.google.gson.annotations.SerializedName

data class MainDataClass(
    @SerializedName("temp")
    var temp: Float,
    @SerializedName("temp_min")
    var temp_min: Float,
    @SerializedName("temp_max")
    var temp_max: Float,
)
