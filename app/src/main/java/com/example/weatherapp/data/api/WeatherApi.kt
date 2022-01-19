package com.example.weatherapp.data.api

import com.example.weatherapp.data.entities.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Retrofit api calls
 */
private const val KEY = "55SC5PB4HZNETSR8MDYB9MLAY"
private const val CONTENT_TYPE = "json"

interface WeatherApi {

    @GET("/{city_name}/{time_period}?")
    suspend fun getWeatherForecast(
        @Path("city_name") cityName: String,
        @Path("time_period") time: String,
        @Query("unitGroup") unitGroup: String,
        @Query("elements") elements: String,
        @Query("include") include: String,
        @Query("key") key: String = KEY,
        @Query("contentType") contentType: String = CONTENT_TYPE,
        ): WeatherResponse
}