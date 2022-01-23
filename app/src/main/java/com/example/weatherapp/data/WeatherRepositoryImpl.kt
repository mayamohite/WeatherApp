package com.example.weatherapp.data

import android.content.Context
import com.example.weatherapp.R
import com.example.weatherapp.data.local.db.entities.*
import com.example.weatherapp.domain.WeatherLocalDataSource
import com.example.weatherapp.domain.WeatherRemoteDataSource
import com.example.weatherapp.domain.WeatherRepository
import com.example.weatherapp.domain.common.Result
import com.example.weatherapp.domain.model.CurrentWeather
import com.example.weatherapp.domain.model.ForecastWeather
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val remoteDataSource: WeatherRemoteDataSource,
    private val localDataSource: WeatherLocalDataSource,
    @ApplicationContext private val context: Context,
) : WeatherRepository {

    override suspend fun getCurrentWeather(
        latitude: Double,
        longitude: Double,
        metric: String
    ): Result<CurrentWeather> {
        val weatherEntity: CurrentWeatherEntity? =
            remoteDataSource.getCurrentWeather(latitude, longitude, metric)
        if (weatherEntity != null) {
            localDataSource.saveCurrentWeather(weatherEntity)
        }
        return getWeatherDetailsFromDb(latitude, longitude)
    }

    override suspend fun getWeatherForecast(
        latitude: Double,
        longitude: Double,
        metric: String
    ): Result<List<ForecastWeather>> {
        val response: CityWithDailyForecast? =
            remoteDataSource.getWeatherForecast(latitude, longitude, metric)
        if (response != null) {
            localDataSource.saveWeatherForecast(
                response.weatherForecastEntity,
                response.dailyForecast
            )
        }
        return getWeatherForecastFromDb(latitude, longitude)
    }

    private suspend fun getWeatherDetailsFromDb(
        latitude: Double,
        longitude: Double
    ): Result<CurrentWeather> {
        val weatherDetails = localDataSource.getCurrentWeather(latitude, longitude)
        return if (weatherDetails == null) {
            Result.Error(context.getString(R.string.current_weather_not_available))
        } else {
            Result.Success(weatherDetails)
        }
    }

    private suspend fun getWeatherForecastFromDb(
        latitude: Double,
        longitude: Double
    ): Result<List<ForecastWeather>> {
        val weatherDetails = localDataSource.getWeatherForecast(latitude, longitude)
        return if (weatherDetails == null || weatherDetails.isEmpty()) {
            Result.Error(context.getString(R.string.weather_forecast_not_available))
        } else {
            Result.Success(weatherDetails)
        }
    }
}
