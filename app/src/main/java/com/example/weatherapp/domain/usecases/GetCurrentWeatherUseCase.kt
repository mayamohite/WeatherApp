package com.example.weatherapp.domain.usecases

import com.example.weatherapp.core.Constants
import com.example.weatherapp.domain.WeatherRepository
import com.example.weatherapp.domain.common.Result
import com.example.weatherapp.domain.model.CurrentWeather
import javax.inject.Inject

class GetCurrentWeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository,
) : BaseUseCase() {

    suspend fun getCurrentWeather(latitude: Double, longitude: Double): Result<CurrentWeather> {
        return weatherRepository.getCurrentWeather(latitude, longitude, Constants.METRIC)
    }
}
