package com.example.weatherapp.data

import android.content.Context
import com.example.weatherapp.R
import com.example.weatherapp.data.local.LocalDataSource
import com.example.weatherapp.data.local.db.entities.*
import com.example.weatherapp.data.remote.RemoteDataSource
import com.example.weatherapp.domain.WeatherRepository
import com.example.weatherapp.domain.common.Result
import com.example.weatherapp.domain.model.CurrentWeather
import com.example.weatherapp.domain.model.ForecastWeather
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    @ApplicationContext private val context: Context,
) : WeatherRepository {

    override suspend fun getCurrentWeather(
        latitude: Double,
        longitude: Double,
        metric: String
    ): Result<CurrentWeather> {
        return try {
            val response = remoteDataSource.getCurrentWeather(latitude, longitude, metric)
            val weatherEntity = CurrentWeatherEntity(latitude, longitude, response)
            localDataSource.saveCurrentWeather(weatherEntity)
            getWeatherDetailsFromDb(latitude, longitude)
        } catch (exception: Exception) {
            getWeatherDetailsFromDb(latitude, longitude)
        }
    }

    override suspend fun getWeatherForecast(
        latitude: Double,
        longitude: Double,
        metric: String
    ): Result<List<ForecastWeather>> {
        return try {
            val response = remoteDataSource.getWeatherForecast(latitude, longitude, metric)
            val weatherForecastEntity = WeatherForecastEntity(latitude, longitude, response)
            val dailyForecastEntity = DailyForecastEntity.mapToDailyForecastEntity(response)
            localDataSource.saveWeatherForecast(weatherForecastEntity, dailyForecastEntity)
            getWeatherForecastFromDb(latitude, longitude)
        } catch (exception: Exception) {
            getWeatherForecastFromDb(latitude, longitude)
        }
    }

    private suspend fun getWeatherDetailsFromDb(
        latitude: Double,
        longitude: Double
    ): Result<CurrentWeather> {
        val weatherDetails = localDataSource.getCurrentWeather(latitude, longitude)
        return if (weatherDetails == null) {
            Result.Error(context.getString(R.string.weather_details_not_available))
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
            Result.Error(context.getString(R.string.weather_details_not_available))
        } else {
            Result.Success(weatherDetails)
        }
    }
}
