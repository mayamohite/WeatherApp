package com.example.weatherapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * Place has 1: Many relation with weather forecast details.
 */
@Entity(tableName = "WeatherForecast")
data class WeatherForecastEntity(
    @PrimaryKey
    val date: Date,
    val maxTemperature: Float,
    val minTemperature: Float,
    val temperature: Float,
    val humidity: Float,
    val windSpeed: Float,
    val pressure: Float,
    val sunrise: String,
    val sunset: String,
    val cityId: String,
)
