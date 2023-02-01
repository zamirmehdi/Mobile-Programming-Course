package com.example.hw5

import com.example.hw5.MainDataClass
import com.google.gson.annotations.SerializedName

data class ListDataClass(
    @SerializedName("main")
    var main: MainDataClass,
    @SerializedName("weather")
    var weather: List<WeatherDataClass>,
    @SerializedName("dt_txt")
    var dt_txt: String,
)
