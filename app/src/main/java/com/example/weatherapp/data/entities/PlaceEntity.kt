package com.example.weatherapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "place")
data class PlaceEntity(
    @PrimaryKey
    val placeName: String,
)
