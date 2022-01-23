package com.example.weatherapp.data

import android.content.Context
import android.os.Build
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.weatherapp.MainCoroutineRule
import com.example.weatherapp.data.local.*
import com.example.weatherapp.data.local.db.entities.CityWithDailyForecast
import com.example.weatherapp.data.local.utils.CURRENT_WEATHER
import com.example.weatherapp.data.local.utils.CURRENT_WEATHER_UI_DATA
import com.example.weatherapp.data.local.utils.DAILY_WEATHER_FORECAST
import com.example.weatherapp.data.local.utils.WEATHER_FORECAST
import com.example.weatherapp.data.remote.RemoteDataSourceImpl
import com.example.weatherapp.domain.WeatherRepository
import com.example.weatherapp.domain.common.Result
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.P])
@RunWith(AndroidJUnit4::class)
class WeatherRepositoryImplTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private val remoteDataSourceImpl: RemoteDataSourceImpl = mock()

    private val localDataSourceImpl: LocalDataSourceImpl = mock()

    lateinit var weatherRepository: WeatherRepository
    private val context = ApplicationProvider.getApplicationContext<Context>()

    @Before
    fun setUp() {
        weatherRepository = WeatherRepositoryImpl(remoteDataSourceImpl, localDataSourceImpl, context)
    }

    @Test
    fun `test get current weather returns error on success result`() = runBlocking {
        whenever(remoteDataSourceImpl.getCurrentWeather(any(), any(), any())).thenReturn(null)
        whenever(localDataSourceImpl.getCurrentWeather(any(), any())).thenReturn(null)

        val actualResult = weatherRepository.getCurrentWeather(any(), any(), any())

        assert(actualResult is Result.Error)
    }

    @Test
    fun `test get current weather returns success when api returns success`() = runBlocking {
        whenever(remoteDataSourceImpl.getCurrentWeather(any(), any(), any()))
            .thenReturn(CURRENT_WEATHER)
        whenever(localDataSourceImpl.getCurrentWeather(any(), any()))
            .thenReturn(CURRENT_WEATHER_UI_DATA)

        val actualResult = weatherRepository.getCurrentWeather(any(), any(), any())

        assert(actualResult is Result.Success)
    }

    @Test
    fun `test get weather forecast returns error on success result`() = runBlocking {
        whenever(remoteDataSourceImpl.getWeatherForecast(any(), any(), any())).thenReturn(null)
        whenever(localDataSourceImpl.getWeatherForecast(any(), any())).thenReturn(null)

        val actualResult = weatherRepository.getCurrentWeather(any(), any(), any())

        assert(actualResult is Result.Error)
    }

    @Test
    fun `test get weather forecast returns error when api returns empty response`() = runBlocking {
        whenever(remoteDataSourceImpl.getWeatherForecast(any(), any(), any()))
            .thenReturn(CityWithDailyForecast())
        whenever(localDataSourceImpl.getWeatherForecast(any(), any()))
            .thenReturn(emptyList())

        val actualResult = weatherRepository.getWeatherForecast(any(), any(), any())

        assert(actualResult is Result.Error)
    }

    @Test
    fun `test get weather forecast returns success when api returns success response`() =
        runBlocking {
            val cityWithDailyForecastModel = CityWithDailyForecast()
            cityWithDailyForecastModel.dailyForecast = DAILY_WEATHER_FORECAST

            whenever(remoteDataSourceImpl.getWeatherForecast(any(), any(), any()))
                .thenReturn(cityWithDailyForecastModel)
            whenever(localDataSourceImpl.getWeatherForecast(any(), any()))
                .thenReturn(WEATHER_FORECAST)

            val actualResult = weatherRepository.getWeatherForecast(any(), any(), any())

            assert(actualResult is Result.Success)
        }
}
