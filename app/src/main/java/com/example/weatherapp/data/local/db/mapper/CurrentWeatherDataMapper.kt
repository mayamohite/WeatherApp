package com.example.weatherapp.data.local.db.mapper

import com.example.weatherapp.data.local.db.entities.CurrentWeatherEntity
import com.example.weatherapp.data.local.db.utils.*
import com.example.weatherapp.domain.common.DataToDomainMapper
import com.example.weatherapp.domain.model.CurrentWeather
import javax.inject.Inject

class CurrentWeatherDataMapper @Inject constructor() :
    DataToDomainMapper<CurrentWeatherEntity?, CurrentWeather?>() {

    override fun map(input: CurrentWeatherEntity?): CurrentWeather? {
        if (input == null) {
            return null
        }
        return CurrentWeather(
            cityName = input.name ?: NO_DATA_SYMBOL,
            humidity = humidity(input.main?.humidity),
            pressure = pressure(input.main?.pressure),
            windSpeed = input.wind?.speed?.toString() ?: NO_DATA_SYMBOL,
            temperatureInCelsius = temperatureInCelsius(input.main?.temp),
            temperatureInFahrenheit = celsiusToFahrenheit(
                input.main?.temp
            ),
        )
    }
}
