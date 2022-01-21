package com.example.weatherapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Place has 1: Many relation with weather forecast details.
 */
@Entity(tableName = "WeatherForecast")
data class WeatherForecastEntity(
    @PrimaryKey
    val cityName: String,
    val longitude: Double?,
    val latitude: Double?,
    val timezone: Long?,
    val sunriseTime: Long?,
    val sunsetTime: Long?,
)
