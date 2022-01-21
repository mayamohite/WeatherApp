package com.example.weatherapp.data.db

import androidx.room.*
import com.example.weatherapp.data.entities.CityWithDailyForecast
import com.example.weatherapp.data.entities.DailyForecastEntity
import com.example.weatherapp.data.entities.WeatherForecastEntity

@Dao
interface WeatherForecastDao {

    @Transaction
    @Query("SELECT * FROM WeatherForecast Where cityName = :cityName")
    suspend fun getDailyForecast(cityName: String): CityWithDailyForecast?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCityDetails(weatherForecastEntity: WeatherForecastEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveDailyForecastDetails(dailyForecastEntity: List<DailyForecastEntity>)

    @Transaction
    suspend fun saveDailyForecast(
        weatherForecastEntity: WeatherForecastEntity,
        dailyForecastEntity: List<DailyForecastEntity>
    ) {
        saveCityDetails(weatherForecastEntity)
        saveDailyForecastDetails(dailyForecastEntity)
    }
}
