package com.example.weatherapp.data.local

import com.example.weatherapp.data.local.db.entities.*

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
    base = "",
    sunrise = 1642694983,
    sunset = 1642694893,
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
    base = "base",
    sunrise = 1642694983,
    sunset = 1642694893,
)

val CITY_DETAILS = WeatherForecastEntity(
    cityName = "Newtonhill",
    latitude = 57.0,
    longitude = -2.15,
    timezone = 0,
    sunriseTime = 1642694983,
    sunsetTime = 1642694893,
)

val DAILY_WEATHER_FORECAST = listOf(
    DailyForecastEntity(
        date = 1642234983,
        main = MAIN_ENTITY,
        visibility = 100,
        wind = WIND_ENTITY,
        dateAndTime = "2022-01-21 09:00:00",
        cityKey = "Newtonhill",
    ),
    DailyForecastEntity(
        date = 1642934983,
        main = MAIN_ENTITY,
        visibility = 1000,
        wind = WIND_ENTITY,
        dateAndTime = "2022-01-21 09:00:00",
        cityKey = "Newtonhill",
    )
)

