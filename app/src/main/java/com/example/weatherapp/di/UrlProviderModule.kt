package com.example.weatherapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Module to provide base url.
 */
@Module
@InstallIn(SingletonComponent::class)
class UrlProviderModule {

    @Provides
    fun getBaseUrl(): String {
        return "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline"
    }
}
