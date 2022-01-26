package com.example.weatherapp.data.local.db.entities

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.weatherapp.data.remote.response.ForecastResponse

/**
 * Place has 1: Many relation with weather forecast details.
 */
@Entity(
    tableName = "WeatherForecast",
    indices = [Index("latitude", "longitude", unique = true)]
)
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
    constructor(latitude: Double, longitude: Double, forecastResponse: ForecastResponse) : this(
        cityName = forecastResponse.city?.name ?: "",
        longitude = longitude,
        latitude = latitude,
        timezone = forecastResponse.city?.timezone,
        sunriseTime = forecastResponse.city?.sunriseTime,
        sunsetTime = forecastResponse.city?.sunsetTime,
    )
}
