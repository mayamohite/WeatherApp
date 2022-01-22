package com.example.weatherapp.data.local.db.mapper

import com.example.weatherapp.data.local.db.entities.CityWithDailyForecast
import com.example.weatherapp.domain.common.DataToDomainMapper
import com.example.weatherapp.domain.model.ForecastWeather
import java.text.DateFormat
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
                    day = getDay(it.formattedDate),
                    temp = it.main?.temp?.toString() ?: " - ",
                    tempInFahrenheit = celsiusToFahrenheit(it.main?.temp),
                    minTemp = it.main?.tempMin?.toString() ?: " - ",
                    minTempInFahrenheit = celsiusToFahrenheit(it.main?.tempMin),
                    maxTemp = it.main?.tempMax?.toString() ?: " - ",
                    maxTempInFahrenheit = celsiusToFahrenheit(it.main?.tempMax),
                    time = getTime(it.dateAndTime) ?: "",
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

    private fun getDay(dateTime: String): String {
        val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd")
        val formattedDate: Date = dateFormat.parse(dateTime)
        return SimpleDateFormat("EEEE").format(formattedDate)
    }

    private fun getTime(datetime: String?): String? {
        return datetime?.substringAfter(" ")?.substringBeforeLast(":")
    }
}
