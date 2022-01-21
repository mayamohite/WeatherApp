package com.example.weatherapp.domain

import com.example.weatherapp.domain.common.Result
import com.example.weatherapp.domain.model.CurrentWeather
import com.example.weatherapp.domain.model.ForecastWeather

interface WeatherRepository {

    suspend fun getCurrentWeather(latitude: Double, longitude: Double): Result<CurrentWeather>

    suspend fun getWeatherForecast(
        latitude: Double,
        longitude: Double
    ): Result<List<ForecastWeather>>
}
