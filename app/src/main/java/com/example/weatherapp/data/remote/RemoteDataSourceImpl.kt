package com.example.weatherapp.data.remote

import com.example.weatherapp.data.local.db.entities.*
import com.example.weatherapp.domain.WeatherRemoteDataSource
import java.lang.Exception
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val weatherApi: WeatherApi,
) : WeatherRemoteDataSource {

    override suspend fun getCurrentWeather(
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

    override suspend fun getWeatherForecast(
        latitude: Double,
        longitude: Double,
        metric: String
    ): CityWithDailyForecast? {
        return try {
            val response = weatherApi.getForecastByGeoCords(latitude, longitude, metric)
            CityWithDailyForecast().get(latitude, longitude, response)
        } catch (exception: Exception) {
            null
        }
    }
}
