package com.example.weatherapp.domain

import com.example.weatherapp.data.local.db.entities.CurrentWeatherEntity
import com.example.weatherapp.domain.model.CurrentWeather

interface WeatherDataSource {

    suspend fun getCurrentWeather(latitude: Double, longitude: Double): CurrentWeather?

    suspend fun saveCurrentWeather(weatherEntity: CurrentWeatherEntity)
}
