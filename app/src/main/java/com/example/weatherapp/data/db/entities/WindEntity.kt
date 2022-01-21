package com.example.weatherapp.data.db.entities

import androidx.room.Entity

@Entity(tableName = "Wind")
data class WindEntity(
    val speed: Double?,
)
