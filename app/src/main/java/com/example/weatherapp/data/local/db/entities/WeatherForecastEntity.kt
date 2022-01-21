package com.example.weatherapp.data.local.db.entities

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.weatherapp.data.remote.response.ForecastResponse

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
) {
    @Ignore
    constructor(forecastResponse: ForecastResponse) : this(
        cityName = forecastResponse.city?.name ?: "",
        longitude = forecastResponse.city?.coordinates?.longitude ?: 0.0,
        latitude = forecastResponse.city?.coordinates?.latitude ?: 0.0,
        timezone = forecastResponse.city?.timezone,
        sunriseTime = forecastResponse.city?.sunriseTime,
        sunsetTime = forecastResponse.city?.sunsetTime,
    )
}
