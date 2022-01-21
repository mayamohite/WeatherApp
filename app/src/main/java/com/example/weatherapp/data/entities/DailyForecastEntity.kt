package com.example.weatherapp.data.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "DailyForecast",
)
data class DailyForecastEntity(
    @PrimaryKey
    val date: Long,
    @Embedded
    val main: MainEntity?,
    val visibility: Int?,
    @Embedded
    val wind: WindEntity?,
    val dateAndTime: String?,
    val cityKey: String,
)

