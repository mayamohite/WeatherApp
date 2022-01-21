package com.example.weatherapp.data.db

import android.os.Build
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.weatherapp.MainCoroutineRule
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
class CurrentWeatherDaoTest {

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
    fun `test database insertion of current weather`() = runBlocking {
        database.getWeatherDao().saveCurrentWeather(CURRENT_WEATHER)
        database.getWeatherDao().saveCurrentWeather(CURRENT_WEATHER_VARIATION)
        database.getWeatherDao().saveCurrentWeather(CURRENT_WEATHER)

        val currentWeather = database.getWeatherDao().getCurrentWeather(57.0, -2.15)
        assert(currentWeather == CURRENT_WEATHER)
    }

    @Test
    fun `test data replace on multiple insertion database `() = runBlocking {
        database.getWeatherDao().saveCurrentWeather(CURRENT_WEATHER)
        database.getWeatherDao().saveCurrentWeather(CURRENT_WEATHER_VARIATION)
        database.getWeatherDao().saveCurrentWeather(CURRENT_WEATHER)

        val currentWeather = database.getWeatherDao().getCurrentWeather(57.0, -2.15)
        assert(currentWeather == CURRENT_WEATHER)
    }

    @After
    fun closeDb() {
        database.close()
    }
}
