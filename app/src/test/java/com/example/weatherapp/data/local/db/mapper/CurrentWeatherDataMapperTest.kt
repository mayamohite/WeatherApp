package com.example.weatherapp.data.local.db.mapper

import com.example.weatherapp.data.local.utils.CURRENT_WEATHER
import com.example.weatherapp.data.local.utils.CURRENT_WEATHER_EMPTY_DATA
import com.example.weatherapp.data.local.utils.CURRENT_WEATHER_UI_DATA
import com.example.weatherapp.data.local.utils.CURRENT_WEATHER_UI_EMPTY_DATA
import com.example.weatherapp.data.local.db.entities.CurrentWeatherEntity
import com.example.weatherapp.data.local.utils.parametersOf
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class CurrentWeatherDataMapperTest(
    private val currentWeatherEntity: CurrentWeatherEntity?,
    private val expectedResult: Any?
) {

    var currentWeatherDataMapper: CurrentWeatherDataMapper = CurrentWeatherDataMapper()

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{0} is mapped to {1}")
        fun testData() = parametersOf(
            null to null,
            CURRENT_WEATHER to CURRENT_WEATHER_UI_DATA,
            CURRENT_WEATHER_EMPTY_DATA to CURRENT_WEATHER_UI_EMPTY_DATA
        )
    }

    @Test
    fun `mapper produces expected result`() {
        Assert.assertEquals(expectedResult, currentWeatherDataMapper.map(currentWeatherEntity))
    }
}
