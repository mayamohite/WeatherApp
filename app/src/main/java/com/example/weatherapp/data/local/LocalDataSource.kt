package com.example.weatherapp.data.local

import com.example.weatherapp.data.local.db.CurrentWeatherDao
import com.example.weatherapp.data.local.db.WeatherForecastDao
import com.example.weatherapp.data.local.db.entities.CurrentWeatherEntity
import com.example.weatherapp.data.local.db.entities.DailyForecastEntity
import com.example.weatherapp.data.local.db.entities.WeatherForecastEntity
import com.example.weatherapp.data.local.db.mapper.CurrentWeatherDataMapper
import com.example.weatherapp.data.local.db.mapper.WeatherForecastDataMapper
import com.example.weatherapp.domain.model.CurrentWeather
import com.example.weatherapp.domain.model.ForecastWeather
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val currentWeatherDao: CurrentWeatherDao,
    private val weatherForecastDao: WeatherForecastDao,
    private val currentWeatherDataMapper: CurrentWeatherDataMapper,
    private val weatherForecastDataMapper: WeatherForecastDataMapper,
) {

    suspend fun getCurrentWeather(latitude: Double, longitude: Double): CurrentWeather? {
        val currentWeatherEntity = currentWeatherDao.getCurrentWeather(latitude, longitude)
        return currentWeatherDataMapper.map(currentWeatherEntity)
    }

    suspend fun saveCurrentWeather(weatherEntity: CurrentWeatherEntity) {
        currentWeatherDao.saveCurrentWeather(weatherEntity)
    }

    suspend fun getWeatherForecast(latitude: Double, longitude: Double): List<ForecastWeather>? {
        val forecastWeatherEntity = weatherForecastDao.getDailyForecast(latitude, longitude)
        return weatherForecastDataMapper.map(forecastWeatherEntity)
    }

    suspend fun saveWeatherForecast(
        weatherForecastEntity: WeatherForecastEntity?,
        dailyForecastEntity: List<DailyForecastEntity>?
    ) {
        weatherForecastDao.saveDailyForecast(weatherForecastEntity, dailyForecastEntity)
    }
}
