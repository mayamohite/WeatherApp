package com.example.weatherapp.data.db

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Before
import org.junit.Test

class WeatherDatabaseTest {

    private lateinit var database: WeatherDatabase
    private lateinit var weatherDao: WeatherDao

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().context,
            WeatherDatabase::class.java
        ).build()

        weatherDao = database.getWeatherDao()
    }

    @Test
    fun test() {
        assert(true)
    }

    @After
    fun tearDown() {
        database.close()
    }
}