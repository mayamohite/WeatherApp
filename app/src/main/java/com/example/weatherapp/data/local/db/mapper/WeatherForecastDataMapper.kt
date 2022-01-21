package com.example.weatherapp.data.local.db.mapper

import com.example.weatherapp.data.local.db.entities.CityWithDailyForecast
import com.example.weatherapp.domain.common.DataToDomainMapper
import com.example.weatherapp.domain.model.ForecastWeather
import java.text.SimpleDateFormat
import java.util.*
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
                    day = getDay(it.date),
                    temp = it.main?.temp?.toString() ?: " - ",
                    tempInFahrenheit = celsiusToFahrenheit(it.main?.temp),
                    minTemp = it.main?.tempMin?.toString() ?: " - ",
                    minTempInFahrenheit = celsiusToFahrenheit(it.main?.tempMin),
                    maxTemp = it.main?.tempMax?.toString() ?: " - ",
                    maxTempInFahrenheit = celsiusToFahrenheit(it.main?.tempMax),
                    time = getTime(it.dateAndTime) ?: ""
                )
            )
        }
        return weatherForecastDetails
    }

    private fun celsiusToFahrenheit(temperature: Double?): String {
        return if (temperature == null) {
            " - "
        } else {
            "%.2f".format(((temperature * 9 / 5) + 32))
        }
    }

    private fun getDay(timestamp: Long): String {
        val calendar = Calendar.getInstance(Locale.getDefault())
        calendar.timeInMillis = timestamp * 1000
        val simpleDateFormat = SimpleDateFormat("EEEE")
        return simpleDateFormat.format(calendar.timeInMillis)
    }

    private fun getTime(datetime: String?): String? {
        return datetime?.substringAfter(" ")?.substringBeforeLast(":")
    }
}
