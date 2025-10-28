package com.example.hw5


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("?units=metric")
    suspend fun getWeatherSituations(
        @Query("lat") lat: Float,
        @Query("lon") lon: Float,
        @Query("appid") appid: String
    ): Response<ResponseListWeathersDataClass>

}