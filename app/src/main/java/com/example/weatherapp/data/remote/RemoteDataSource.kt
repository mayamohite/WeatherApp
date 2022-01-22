package com.example.weatherapp.data.remote

import com.example.weatherapp.data.remote.response.CurrentWeatherResponse
import com.example.weatherapp.data.remote.response.ForecastResponse
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val weatherApi: WeatherApi,
) {
    suspend fun getCurrentWeather(
        latitude: Double,
        longitude: Double,
        metric: String
    ): CurrentWeatherResponse {
        return weatherApi.getCurrentWeatherByGeoCords(latitude, longitude, metric)
    }

    suspend fun getWeatherForecast(
        latitude: Double,
        longitude: Double,
        metric: String
    ): ForecastResponse {
        return weatherApi.getForecastByGeoCords(latitude, longitude, metric)
    }
}
