package com.example.weatherapp.domain.model

data class ForecastWeather(
    val day: String,
    var temp: String,
    val tempInFahrenheit: String,
    val minTemp: String,
    val minTempInFahrenheit: String,
    val maxTemp: String,
    val maxTempInFahrenheit: String,
    val time: String,
)
