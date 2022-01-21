package com.example.weatherapp.data.local.db.entities

import androidx.room.Entity
import androidx.room.Ignore
import com.example.weatherapp.data.remote.response.Main

@Entity(tableName = "Main")
data class MainEntity(
    var temp: Double?,
    var tempMin: Double?,
    var humidity: Int?,
    var pressure: Double?,
    var tempMax: Double?,
) {
    @Ignore
    constructor(main: Main?) : this(
        temp = main?.temperature,
        tempMin = main?.minTemperature,
        tempMax = main?.maxTemperature,
        humidity = main?.humidity,
        pressure = main?.pressure,
    )
}
