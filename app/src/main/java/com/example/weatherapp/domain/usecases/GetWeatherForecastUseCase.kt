package com.example.weatherapp.domain.usecases

import com.example.weatherapp.core.Constants
import com.example.weatherapp.domain.WeatherRepository
import com.example.weatherapp.domain.common.Result
import com.example.weatherapp.domain.model.ForecastWeather
import javax.inject.Inject

class GetWeatherForecastUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository,
) : BaseUseCase() {
    suspend fun getWeatherForecast(
        latitude: Double,
        longitude: Double
    ): Result<List<ForecastWeather>> {
        return weatherRepository.getWeatherForecast(latitude, longitude, Constants.METRIC)
    }
}
