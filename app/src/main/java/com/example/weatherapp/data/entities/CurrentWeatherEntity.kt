package com.example.weatherapp.data.entities

import androidx.room.*
import java.util.*

/**
 * Place has 1:1 relation with current weather details.
 */
@Entity(tableName = "current_weather")
data class CurrentWeatherEntity(
    @PrimaryKey
    val date: Date,
    val city: String,
    val temperature: Float,
    val humidity: Float,
    val windSpeed: Float,
    val pressure: Float,
    val sunrise: String,
    val sunset: String,
)

data class CurrentWeatherAndPlace(
    @Embedded val user: PlaceEntity,
    @Relation(
        parentColumn = "placeName",
        entityColumn = "city"
    )
    val library: CurrentWeatherEntity
)