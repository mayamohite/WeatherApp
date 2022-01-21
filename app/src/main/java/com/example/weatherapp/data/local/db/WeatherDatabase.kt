package com.example.weatherapp.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.weatherapp.data.local.db.entities.CurrentWeatherEntity
import com.example.weatherapp.data.local.db.entities.DailyForecastEntity
import com.example.weatherapp.data.local.db.entities.DateConverter
import com.example.weatherapp.data.local.db.entities.WeatherForecastEntity

const val WEATHER_DATABASE = "weather_database"

@Database(
    entities = [
        CurrentWeatherEntity::class,
        WeatherForecastEntity::class,
        DailyForecastEntity::class,
    ], version = 1
)
@TypeConverters(DateConverter::class)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun getWeatherDao(): CurrentWeatherDao
    abstract fun getForecastDao(): WeatherForecastDao
}
