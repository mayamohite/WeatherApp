package com.example.weatherapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.weatherapp.data.entities.*

const val WEATHER_DATABASE = "weather_database"

@Database(
    entities = [
        CurrentWeatherEntity::class,
        WeatherForecastEntity::class,
    ], version = 1
)
@TypeConverters(DateConverter::class)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun getWeatherDao(): CurrentWeatherDao
}
