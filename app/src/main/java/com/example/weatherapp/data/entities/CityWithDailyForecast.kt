package com.example.weatherapp.data.entities

import androidx.room.Embedded
import androidx.room.Relation

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
