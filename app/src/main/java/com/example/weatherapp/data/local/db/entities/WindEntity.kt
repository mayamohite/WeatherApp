package com.example.weatherapp.data.local.db.entities

import androidx.room.Entity
import androidx.room.Ignore
import com.example.weatherapp.data.remote.response.Wind

@Entity(tableName = "Wind")
data class WindEntity(
    val speed: Double?,
) {
    @Ignore
    constructor(wind: Wind?) : this(
        speed = wind?.speed,
    )
}
