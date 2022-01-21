package com.example.weatherapp.data.local.db.entities

import androidx.room.*
import com.example.weatherapp.data.remote.response.CurrentWeatherResponse

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
    val sunrise: Long?,
    val sunset: Long?,
) {
    @Ignore
    constructor(currentWeather: CurrentWeatherResponse) : this(
        visibility = currentWeather.visibility,
        timezone = currentWeather.timezone,
        main = MainEntity(currentWeather.main),
        date = currentWeather.date,
        name = currentWeather.name,
        base = currentWeather.base,
        wind = WindEntity(currentWeather.wind?.speed),
        latitude = currentWeather.coordinates?.latitude ?: 0.0,
        longitude = currentWeather.coordinates?.longitude ?: 0.0,
        sunrise = currentWeather.sys?.sunriseTime,
        sunset = currentWeather.sys?.sunsetTime,
    )
}

