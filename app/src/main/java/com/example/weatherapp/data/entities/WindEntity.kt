package com.example.weatherapp.data.entities

import androidx.room.Entity

@Entity(tableName = "Wind")
data class WindEntity(
    val speed: Double?,
)
