package com.example.weatherapp.data.local.utils

import com.example.weatherapp.data.local.db.entities.*
import com.example.weatherapp.domain.model.CurrentWeather
import com.example.weatherapp.domain.model.ForecastWeather

const val NO_DATA_SYMBOL = " - "

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
        formattedDate = "2022-01-21"
    ),
    DailyForecastEntity(
        date = 1642934983,
        main = MAIN_ENTITY,
        visibility = 1000,
        wind = WIND_ENTITY,
        dateAndTime = "2022-01-21 09:00:00",
        cityKey = "Newtonhill",
        formattedDate = "2022-01-22"
    )
)

val CURRENT_WEATHER_UI_DATA = CurrentWeather(
    cityName = "Newtonhill",
    humidity = "90%",
    pressure = "400.8 mBar",
    windSpeed = "100.9",
    temperatureInCelsius = "36.2°C",
    temperatureInFahrenheit = "97.16°F",
)

val CURRENT_WEATHER_EMPTY_DATA = CurrentWeatherEntity(
    visibility = null,
    timezone = null,
    main = null,
    date = null,
    name = null,
    wind = null,
    latitude = 57.0,
    longitude = -2.15,
    base = null,
    sunrise = null,
    sunset = null,
)

val CURRENT_WEATHER_UI_EMPTY_DATA = CurrentWeather(
    cityName = NO_DATA_SYMBOL,
    humidity = NO_DATA_SYMBOL,
    pressure = NO_DATA_SYMBOL,
    windSpeed = NO_DATA_SYMBOL,
    temperatureInCelsius = NO_DATA_SYMBOL,
    temperatureInFahrenheit = NO_DATA_SYMBOL,
)

val WEATHER_FORECAST = listOf(
    ForecastWeather(
        day = "Friday",
        temp = "36.2°C",
        tempInFahrenheit = "97.16°F",
        minTemp = "19.8°C",
        minTempInFahrenheit = "67.64°F",
        maxTemp = "23.3°C",
        maxTempInFahrenheit = "73.94°F",
        time = "09:00"
    ),
    ForecastWeather(
        day = "Saturday",
        temp = "36.2°C",
        tempInFahrenheit = "97.16°F",
        minTemp = "19.8°C",
        minTempInFahrenheit = "67.64°F",
        maxTemp = "23.3°C",
        maxTempInFahrenheit = "73.94°F",
        time = "09:00"
    )
)

