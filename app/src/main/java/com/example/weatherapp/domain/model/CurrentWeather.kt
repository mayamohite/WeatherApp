package com.example.weatherapp.domain.model

data class CurrentWeather(
    val cityName: String,
    val humidity: String,
    val pressure: String,
    val windSpeed: String,
    val temperatureInCelsius: String,
    val temperatureInFahrenheit: String,
)
