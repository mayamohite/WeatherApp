package com.example.weatherapp.data.local

import android.os.Build
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.weatherapp.MainCoroutineRule
import com.example.weatherapp.data.local.db.WeatherDatabase
import com.example.weatherapp.data.local.db.entities.CityWithDailyForecast
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.P])
@RunWith(AndroidJUnit4::class)
class WeatherForecastDaoTest {

    private lateinit var database: WeatherDatabase

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Before
    fun initDb() {
        // using an in-memory database because the information stored here disappears when the
        // process is killed
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            WeatherDatabase::class.java
        ).build()
    }

    @Test
    fun `test data insertion in weather forecast table`() = runBlocking {
        database.getForecastDao().saveDailyForecast(CITY_DETAILS, DAILY_WEATHER_FORECAST)

        val weatherForecast: CityWithDailyForecast? =
            database.getForecastDao().getDailyForecast(57.0, -2.15)
        assert(weatherForecast != null)
        assert(weatherForecast!!.dailyForecast!!.size == 2)
        assert(weatherForecast.weatherForecastEntity == CITY_DETAILS)
        assert(weatherForecast.dailyForecast?.get(0) == DAILY_WEATHER_FORECAST[0])
        assert(weatherForecast.dailyForecast?.get(1) == DAILY_WEATHER_FORECAST[1])
    }

    @Test
    fun `test data replace in weather forecast table for same city`() = runBlocking {
        database.getForecastDao().saveDailyForecast(CITY_DETAILS, DAILY_WEATHER_FORECAST)
        database.getForecastDao().saveDailyForecast(CITY_DETAILS, DAILY_WEATHER_FORECAST)

        val weatherForecast: CityWithDailyForecast? =
            database.getForecastDao().getDailyForecast(57.0, -2.15)
        assert(weatherForecast != null)
        assert(weatherForecast!!.dailyForecast!!.size == 2)
        assert(weatherForecast.weatherForecastEntity == CITY_DETAILS)
        assert(weatherForecast.dailyForecast?.get(0) == DAILY_WEATHER_FORECAST[0])
        assert(weatherForecast.dailyForecast?.get(1) == DAILY_WEATHER_FORECAST[1])
    }

    @After
    fun closeDb() {
        database.close()
    }
}
