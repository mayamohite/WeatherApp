package com.example.weatherapp.data.api

import com.example.weatherapp.data.api.response.CurrentWeatherResponse
import com.example.weatherapp.data.api.response.ForecastResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit api calls
 */

interface WeatherApi {

    @GET("forecast")
    suspend fun getForecastByGeoCords(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") units: String,
        @Query("cnt") noOfDays: Int = 5,
    ): ForecastResponse

    @GET("weather")
    suspend fun getCurrentWeatherByGeoCords(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") units: String,
    ): CurrentWeatherResponse
}
