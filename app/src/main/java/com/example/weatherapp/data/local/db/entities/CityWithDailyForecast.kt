package com.example.weatherapp.data.local.db.entities

import androidx.room.Embedded
import androidx.room.Relation
import com.example.weatherapp.data.remote.response.ForecastResponse

class CityWithDailyForecast {

    @Embedded
    var weatherForecastEntity: WeatherForecastEntity? = null

    @Relation(
        parentColumn = "cityName",
        entityColumn = "cityKey",
        entity = DailyForecastEntity::class
    )

    var dailyForecast: List<DailyForecastEntity>? = null
}

fun CityWithDailyForecast.get(
    latitude: Double,
    longitude: Double,
    forecastResponse: ForecastResponse
): CityWithDailyForecast {
    val weatherForecastEntity = WeatherForecastEntity(latitude, longitude, forecastResponse)
    val dailyForecastEntity = DailyForecastEntity.mapToDailyForecastEntity(forecastResponse)
    this.dailyForecast = dailyForecastEntity
    this.weatherForecastEntity = weatherForecastEntity
    return this
}
