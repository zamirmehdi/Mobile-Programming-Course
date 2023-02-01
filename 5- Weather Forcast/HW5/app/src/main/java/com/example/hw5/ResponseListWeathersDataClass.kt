package com.example.hw5

import com.example.hw5.CityDataClass
import com.example.hw5.ListDataClass
import com.google.gson.annotations.SerializedName

data class ResponseListWeathersDataClass(
    @SerializedName("country")
    var country: String,
    @SerializedName("city")
    var city: CityDataClass,
    @SerializedName("list")
    var list: List<ListDataClass>,
)
