package com.example.weatherapp.data.datasource.remote.model

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    val latitude: Float,
    val longitude: Float,
    @SerializedName("address")
    val cityName: String,
    @SerializedName("days")
    val weatherForecast: List<WeatherForecast>,
    @SerializedName("currentConditions")
    val currentWeather: CurrentWeather,
)

data class WeatherForecast(
    @SerializedName("datetime")
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

data class CurrentWeather(
    @SerializedName("datetime")
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
