package com.example.weatherapp.domain

import com.example.weatherapp.data.local.db.entities.CurrentWeatherEntity
import com.example.weatherapp.data.local.db.entities.DailyForecastEntity
import com.example.weatherapp.data.local.db.entities.WeatherForecastEntity
import com.example.weatherapp.domain.model.CurrentWeather
import com.example.weatherapp.domain.model.ForecastWeather

interface WeatherLocalDataSource {

    suspend fun getCurrentWeather(latitude: Double, longitude: Double): CurrentWeather?

    suspend fun saveCurrentWeather(weatherEntity: CurrentWeatherEntity)

    suspend fun getWeatherForecast(latitude: Double, longitude: Double): List<ForecastWeather>?

    suspend fun saveWeatherForecast(
        weatherForecastEntity: WeatherForecastEntity?,
        dailyForecastEntity: List<DailyForecastEntity>?
    )
}
