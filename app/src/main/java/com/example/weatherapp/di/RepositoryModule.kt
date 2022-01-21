package com.example.weatherapp.di

import com.example.weatherapp.data.WeatherRepositoryImpl
import com.example.weatherapp.domain.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsRepository(weatherRepositoryImpl: WeatherRepositoryImpl): WeatherRepository
}
