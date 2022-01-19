package com.example.weatherapp.data.db

import androidx.room.Dao
import androidx.room.Query
import com.example.weatherapp.data.entities.WeatherResponse

@Dao
interface WeatherDao {

    @Query("SELECT * FROM weather")
    fun getCurrentWeather(): WeatherResponse
}