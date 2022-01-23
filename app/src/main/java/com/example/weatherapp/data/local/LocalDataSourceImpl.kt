package com.example.weatherapp.data.local

import com.example.weatherapp.data.local.db.CurrentWeatherDao
import com.example.weatherapp.data.local.db.WeatherForecastDao
import com.example.weatherapp.data.local.db.entities.CurrentWeatherEntity
import com.example.weatherapp.data.local.db.entities.DailyForecastEntity
import com.example.weatherapp.data.local.db.entities.WeatherForecastEntity
import com.example.weatherapp.data.local.db.mapper.CurrentWeatherDataMapper
import com.example.weatherapp.data.local.db.mapper.WeatherForecastDataMapper
import com.example.weatherapp.domain.WeatherLocalDataSource
import com.example.weatherapp.domain.model.CurrentWeather
import com.example.weatherapp.domain.model.ForecastWeather
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val currentWeatherDao: CurrentWeatherDao,
    private val weatherForecastDao: WeatherForecastDao,
    private val currentWeatherDataMapper: CurrentWeatherDataMapper,
    private val weatherForecastDataMapper: WeatherForecastDataMapper,
) : WeatherLocalDataSource {

    override suspend fun getCurrentWeather(latitude: Double, longitude: Double): CurrentWeather? {
        val currentWeatherEntity = currentWeatherDao.getCurrentWeather(latitude, longitude)
        return currentWeatherDataMapper.map(currentWeatherEntity)
    }

    override suspend fun saveCurrentWeather(weatherEntity: CurrentWeatherEntity) {
        currentWeatherDao.saveCurrentWeather(weatherEntity)
    }

    override suspend fun getWeatherForecast(
        latitude: Double,
        longitude: Double
    ): List<ForecastWeather>? {
        val forecastWeatherEntity = weatherForecastDao.getDailyForecast(latitude, longitude)
        return weatherForecastDataMapper.map(forecastWeatherEntity)
    }

    override suspend fun saveWeatherForecast(
        weatherForecastEntity: WeatherForecastEntity?,
        dailyForecastEntity: List<DailyForecastEntity>?
    ) {
        weatherForecastDao.saveDailyForecast(weatherForecastEntity, dailyForecastEntity)
    }
}
