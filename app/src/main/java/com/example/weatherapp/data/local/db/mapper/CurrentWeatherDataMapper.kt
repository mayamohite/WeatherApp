package com.example.weatherapp.data.local.db.mapper

import com.example.weatherapp.data.local.db.entities.CurrentWeatherEntity
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
            cityName = input.name ?: " - ",
            humidity = input.main?.humidity?.toString() ?: " - ",
            pressure = input.main?.pressure?.toString() ?: " - ",
            sunrise = "",
            sunset = "",
            temperatureInCelsius = input.main?.temp?.toString() ?: " - ",
            temperatureInFahrenheit = celsiusToFahrenheit(
                input.main?.temp
            ),
        )
    }

    private fun celsiusToFahrenheit(temperature: Double?): String {
        return if (temperature == null) {
            " - "
        } else {
            "%.2f".format(((temperature * 9 / 5) + 32))
        }
    }
}
