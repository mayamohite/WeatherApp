package com.example.weatherapp.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Place has 1: Many relation with weather forecast details.
 */
@Entity(tableName = "WeatherForecast")
data class WeatherForecastEntity(
    @PrimaryKey
    val cityName: String,
    val longitude: Double,
    val latitude: Double,
    val timezone: Long?,
    val sunriseTime: Long?,
    val sunsetTime: Long?,
)
