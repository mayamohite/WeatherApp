package com.example.weatherapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [WeatherDao::class], version = 1)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun getWeatherDao(): WeatherDao
}