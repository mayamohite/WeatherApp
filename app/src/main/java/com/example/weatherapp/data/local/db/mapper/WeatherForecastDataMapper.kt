package com.example.weatherapp.data.local.db.mapper

import com.example.weatherapp.data.local.db.entities.CityWithDailyForecast
import com.example.weatherapp.data.local.db.utils.NO_DATA_SYMBOL
import com.example.weatherapp.data.local.db.utils.celsiusToFahrenheit
import com.example.weatherapp.data.local.db.utils.getDay
import com.example.weatherapp.data.local.db.utils.getTime
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
                    temp = it.main?.temp?.toString() ?: NO_DATA_SYMBOL,
                    tempInFahrenheit = celsiusToFahrenheit(it.main?.temp),
                    minTemp = it.main?.tempMin?.toString() ?: NO_DATA_SYMBOL,
                    minTempInFahrenheit = celsiusToFahrenheit(it.main?.tempMin),
                    maxTemp = it.main?.tempMax?.toString() ?: NO_DATA_SYMBOL,
                    maxTempInFahrenheit = celsiusToFahrenheit(it.main?.tempMax),
                    time = getTime(it.dateAndTime) ?: "",
                )
            )
        }
        return weatherForecastDetails
    }
}
