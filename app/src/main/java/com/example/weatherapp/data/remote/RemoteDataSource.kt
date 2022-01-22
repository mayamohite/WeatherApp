package com.example.weatherapp.data.remote

import com.example.weatherapp.data.local.db.entities.CityWithDailyForecast
import com.example.weatherapp.data.local.db.entities.CurrentWeatherEntity
import com.example.weatherapp.data.local.db.entities.DailyForecastEntity
import com.example.weatherapp.data.local.db.entities.WeatherForecastEntity
import java.lang.Exception
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val weatherApi: WeatherApi,
) {
    suspend fun getCurrentWeather(
        latitude: Double,
        longitude: Double,
        metric: String
    ): CurrentWeatherEntity? {
        return try {
            val response = weatherApi.getCurrentWeatherByGeoCords(latitude, longitude, metric)
            CurrentWeatherEntity(latitude, longitude, response)
        } catch (exception: Exception) {
            null
        }
    }

    suspend fun getWeatherForecast(
        latitude: Double,
        longitude: Double,
        metric: String
    ): CityWithDailyForecast? {
        return try {
            val response = weatherApi.getForecastByGeoCords(latitude, longitude, metric)
            val weatherForecastEntity = WeatherForecastEntity(latitude, longitude, response)
            val dailyForecastEntity = DailyForecastEntity.mapToDailyForecastEntity(response)
            val cityWithDailyForecast = CityWithDailyForecast()
            cityWithDailyForecast.dailyForecast = dailyForecastEntity
            cityWithDailyForecast.weatherForecastEntity = weatherForecastEntity
            cityWithDailyForecast
        } catch (exception: Exception) {
            null
        }
    }
}
