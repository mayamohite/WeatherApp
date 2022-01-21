package com.example.weatherapp.data.remote

import com.example.weatherapp.core.Constants
import com.example.weatherapp.data.remote.response.CurrentWeatherResponse
import com.example.weatherapp.data.remote.response.ForecastResponse
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val weatherApi: WeatherApi,
) {
    suspend fun getCurrentWeather(latitude: Double, longitude: Double): CurrentWeatherResponse {
        return weatherApi.getCurrentWeatherByGeoCords(latitude, longitude, Constants.METRIC)
    }

    suspend fun getWeatherForecast(latitude: Double, longitude: Double): ForecastResponse {
        return weatherApi.getForecastByGeoCords(latitude, longitude, Constants.METRIC)
    }
}
