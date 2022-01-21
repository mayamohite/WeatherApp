package com.example.weatherapp.data.db.entities

import androidx.room.*

/**
 * @see latitude and @see [longitude] are as composite primary keys.
 */
@Entity(
    tableName = "CurrentWeather",
    primaryKeys = ["latitude", "longitude"]
)
data class CurrentWeatherEntity(
    var visibility: Int?,
    var timezone: Int?,
    @Embedded
    var main: MainEntity?,
    var date: Long?,
    @ColumnInfo(name = "city")
    val name: String?,
    val base: String?,
    @Embedded
    val wind: WindEntity?,
    val latitude: Double,
    val longitude: Double,
)

