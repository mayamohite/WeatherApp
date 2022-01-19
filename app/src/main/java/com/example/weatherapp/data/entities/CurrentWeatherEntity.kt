package com.example.weatherapp.data.entities

import androidx.room.*
import java.text.SimpleDateFormat
import java.util.*

@Entity(tableName = "current_weather")
data class CurrentWeatherEntity(
    @PrimaryKey
    val date: Date,
    val city: String
)

data class CurrentWeatherAndPlace(
    @Embedded val user: PlaceEntity,
    @Relation(
        parentColumn = "placeName",
        entityColumn = "city"
    )
    val library: CurrentWeatherEntity
)

class DateConverter {

    @TypeConverter
    fun fromDate(date: Date): String {
        return SimpleDateFormat("EEE, dd MMM", Locale.getDefault()).format(date)
    }

    @TypeConverter
    fun toDate(date: String): Date {
        return SimpleDateFormat("yyyy-MM-dd").parse(date)
    }
}