package com.example.weatherapp.data.db

import androidx.room.*
import com.example.weatherapp.data.db.entities.CityWithDailyForecast
import com.example.weatherapp.data.db.entities.DailyForecastEntity
import com.example.weatherapp.data.db.entities.WeatherForecastEntity

@Dao
interface WeatherForecastDao {

    @Transaction
    @Query("SELECT * FROM WeatherForecast Where latitude = :latitude AND longitude = :longitude")
    suspend fun getDailyForecast(latitude: Double, longitude: Double): CityWithDailyForecast?

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
