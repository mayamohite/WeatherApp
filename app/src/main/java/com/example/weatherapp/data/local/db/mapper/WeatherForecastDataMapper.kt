package com.example.weatherapp.data.local.db.mapper

import com.example.weatherapp.data.local.db.entities.CityWithDailyForecast
import com.example.weatherapp.data.local.db.utils.*
import com.example.weatherapp.domain.common.DataToDomainMapper
import com.example.weatherapp.domain.model.ForecastWeather
import javax.inject.Inject

class WeatherForecastDataMapper @Inject constructor(
) : DataToDomainMapper<CityWithDailyForecast?, List<ForecastWeather>?>() {

    override fun map(input: CityWithDailyForecast?): List<ForecastWeather>? {
        if (input?.dailyForecast == null) {
            return null
        }
        val weatherForecastDetails = mutableListOf<ForecastWeather>()
        input.dailyForecast?.forEach {
            weatherForecastDetails.add(
                ForecastWeather(
                    day = getDay(it.formattedDate),
                    temp = temperatureInCelsius(it.main?.temp),
                    tempInFahrenheit = celsiusToFahrenheit(it.main?.temp),
                    minTemp = temperatureInCelsius(it.main?.tempMin),
                    minTempInFahrenheit = celsiusToFahrenheit(it.main?.tempMin),
                    maxTemp = temperatureInCelsius(it.main?.tempMax),
                    maxTempInFahrenheit = celsiusToFahrenheit(it.main?.tempMax),
                    time = getTime(it.dateAndTime) ?: "",
                )
            )
        }
        return weatherForecastDetails
    }
}
