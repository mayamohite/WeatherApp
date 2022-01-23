package com.example.weatherapp.domain

import com.example.weatherapp.data.local.db.entities.CityWithDailyForecast
import com.example.weatherapp.data.local.db.entities.CurrentWeatherEntity

interface WeatherRemoteDataSource {

    suspend fun getCurrentWeather(
        latitude: Double,
        longitude: Double,
        metric: String
    ): CurrentWeatherEntity?

    suspend fun getWeatherForecast(
        latitude: Double,
        longitude: Double,
        metric: String
    ): CityWithDailyForecast?
}
