package com.example.weatherapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "weather")
data class WeatherResponse(
    val latitude: Float,
    val longitude: Float,
    @SerializedName("address")
    @PrimaryKey
    val cityName: String,
    @SerializedName("days")
    val weatherForecast: List<WeatherForecast>,
    @SerializedName("currentConditions")
    val currentWeather: CurrentWeather,
)

@Entity(tableName = "weather_forecast")
data class WeatherForecast(
    @SerializedName("datetime")
    @PrimaryKey
    val date: String,
    @SerializedName("tempmax")
    val maxTemperature: Float,
    @SerializedName("tempmin")
    val minTemperature: Float,
    @SerializedName("temp")
    val temperature: Float,
    val humidity: Float,
    @SerializedName("windspeed")
    val windSpeed: Float,
    val pressure: Float,
    val sunrise: String,
    val sunset: String,
)

@Entity(tableName = "current_weather")
data class CurrentWeather(
    @SerializedName("datetime")
    @PrimaryKey
    val date: String,
    @SerializedName("temp")
    val temperature: Float,
    val humidity: Float,
    @SerializedName("windspeed")
    val windSpeed: Float,
    val pressure: Float,
    val sunrise: String,
    val sunset: String,
)
