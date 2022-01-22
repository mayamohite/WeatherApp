package com.example.weatherapp.presentation.weatherdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.domain.common.Result
import com.example.weatherapp.domain.model.CurrentWeather
import com.example.weatherapp.domain.model.ForecastWeather
import com.example.weatherapp.domain.usecases.GetCurrentWeatherUseCase
import com.example.weatherapp.domain.usecases.GetWeatherForecastUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import javax.inject.Inject

@HiltViewModel
class WeatherDetailsViewModel @Inject constructor(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    private val getWeatherForecastUseCase: GetWeatherForecastUseCase,
) : ViewModel() {

    private val _currentWeatherLiveData: MutableLiveData<Result<CurrentWeather>> = MutableLiveData()
    val currentWeatherLiveData: LiveData<Result<CurrentWeather>> = _currentWeatherLiveData

    private val _forecastWeatherLiveData: MutableLiveData<Result<List<ForecastWeather>>> =
        MutableLiveData()
    val forecastWeatherLiveData: LiveData<Result<List<ForecastWeather>>> = _forecastWeatherLiveData

    fun getWeatherDetails(latitude: Double, longitude: Double) {
        viewModelScope.launch(Dispatchers.IO) {
            _currentWeatherLiveData.postValue(Result.Loading)
            supervisorScope {
                val weatherForecastResult = async {
                    getWeatherForecastUseCase.getWeatherForecast(latitude, longitude)
                }

                val currentWeatherResult = async {
                    getCurrentWeatherUseCase.getCurrentWeather(
                        latitude,
                        longitude
                    )
                }
                try {
                    _currentWeatherLiveData.postValue(currentWeatherResult.await())
                    _forecastWeatherLiveData.postValue(weatherForecastResult.await())
                } catch (exception: Exception) {

                } finally {

                }
            }
        }
    }
}
