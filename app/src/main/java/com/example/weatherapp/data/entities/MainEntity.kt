package com.example.weatherapp.data.entities

import androidx.room.Entity

@Entity(tableName = "Main")
data class MainEntity(
    var temp: Double?,
    var tempMin: Double?,
    var humidity: Int?,
    var pressure: Double?,
    var tempMax: Double?,
)
