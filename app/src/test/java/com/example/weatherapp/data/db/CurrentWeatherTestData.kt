package com.example.weatherapp.data.db

import com.example.weatherapp.data.entities.CurrentWeatherEntity
import com.example.weatherapp.data.entities.MainEntity
import com.example.weatherapp.data.entities.WindEntity

val MAIN_ENTITY = MainEntity(
    temp = 36.2,
    tempMin = 19.8,
    humidity = 90,
    pressure = 400.8,
    tempMax = 23.3,
)
val WIND_ENTITY = WindEntity(
    speed = 100.9,
)

val CURRENT_WEATHER = CurrentWeatherEntity(
    visibility = 1000,
    timezone = 0,
    main = MAIN_ENTITY,
    date = 1642694983,
    name = "Newtonhill",
    wind = WIND_ENTITY,
    latitude = 57.0,
    longitude = -2.15,
    base = ""
)

val CURRENT_WEATHER_VARIATION = CurrentWeatherEntity(
    visibility = 100,
    timezone = 0,
    main = MAIN_ENTITY,
    date = 1642234983,
    name = "Newtonhill",
    wind = WIND_ENTITY,
    latitude = 57.0,
    longitude = -2.15,
    base = "base"
)

