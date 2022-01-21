package com.example.weatherapp.di

import android.content.Context
import androidx.room.Room
import com.example.weatherapp.data.local.db.WEATHER_DATABASE
import com.example.weatherapp.data.local.db.CurrentWeatherDao
import com.example.weatherapp.data.local.db.WeatherDatabase
import com.example.weatherapp.data.local.db.WeatherForecastDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext applicationContext: Context): WeatherDatabase {
        return Room.databaseBuilder(
            applicationContext,
            WeatherDatabase::class.java, WEATHER_DATABASE
        ).build()
    }

    @Provides
    fun provideCurrentWeatherDao(appDatabase: WeatherDatabase): CurrentWeatherDao {
        return appDatabase.getWeatherDao()
    }

    @Provides
    fun provideWeatherForecastDao(appDatabase: WeatherDatabase): WeatherForecastDao {
        return appDatabase.getForecastDao()
    }
}
