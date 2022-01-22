package com.example.weatherapp.data.local.db.mapper

import com.example.weatherapp.data.local.DAILY_WEATHER_FORECAST
import com.example.weatherapp.data.local.WEATHER_FORECAST
import com.example.weatherapp.data.local.db.entities.CityWithDailyForecast
import org.junit.Test

class WeatherForecastDataMapperTest {
    var weatherForecastDataMapper: WeatherForecastDataMapper = WeatherForecastDataMapper()


    @Test
    fun `test null mapping`() {
        val actualResult = weatherForecastDataMapper.map(null)
        assert(actualResult == null)
    }

    @Test
    fun `test data mapping for non null values`() {
        val cityWithDailyForecastModel = CityWithDailyForecast()
        cityWithDailyForecastModel.dailyForecast = DAILY_WEATHER_FORECAST

        val actualResult = weatherForecastDataMapper.map(cityWithDailyForecastModel)
        assert(actualResult == WEATHER_FORECAST)
    }
}

