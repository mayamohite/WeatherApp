package com.example.weatherapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.weatherapp.data.entities.CurrentWeatherAndPlace
import com.example.weatherapp.data.entities.WeatherResponse

@Dao
interface WeatherDao {

    @Transaction
    @Query("SELECT * FROM place")
    fun getCurrentWeather(): List<CurrentWeatherAndPlace>
}
