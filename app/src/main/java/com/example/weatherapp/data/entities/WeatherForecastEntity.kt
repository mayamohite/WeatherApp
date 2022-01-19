package com.example.weatherapp.data.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import java.util.*

/**
 * Place has 1: Many relation with weather forecast details.
 */
@Entity(tableName = "weather_forecast")
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

data class PlaceWithWeatherForecasts(
    @Embedded val place: PlaceEntity,
    @Relation(
        parentColumn = "placeName",
        entityColumn = "cityId"
    )
    val playlists: List<WeatherForecastEntity>
)
