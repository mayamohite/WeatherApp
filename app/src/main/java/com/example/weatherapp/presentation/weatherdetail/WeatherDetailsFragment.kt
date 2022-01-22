package com.example.weatherapp.presentation.weatherdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.domain.model.CurrentWeather
import com.example.weatherapp.domain.model.ForecastWeather
import com.example.weatherapp.presentation.utils.ResultObserver
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class WeatherDetailsFragment : Fragment() {

    private lateinit var fragmentView: View
    private val weatherDetailsViewModel: WeatherDetailsViewModel by activityViewModels()
    private lateinit var progressBar: ProgressBar

    @Inject
    lateinit var weatherForecastAdapter: WeatherForecastAdapter
    lateinit var rvWeatherForecast: RecyclerView
    private val tvPressure by lazy {
        fragmentView.findViewById<TextView>(R.id.tv_pressure_value)
    }
    private val tvWindSpeed by lazy {
        fragmentView.findViewById<TextView>(R.id.tv_wind_value)
    }
    private val tvHumidity by lazy {
        fragmentView.findViewById<TextView>(R.id.tv_humidity_value)
    }
    private val tvTemperature by lazy {
        fragmentView.findViewById<TextView>(R.id.tv_temperature)
    }
    private val tvCityName by lazy {
        fragmentView.findViewById<TextView>(R.id.tv_city)
    }
    private val gpCurrentWeather by lazy {
        fragmentView.findViewById<Group>(R.id.current_weather_details)
    }
    private val tvCurrentWeatherError by lazy {
        fragmentView.findViewById<TextView>(R.id.tv_current_weather_error)
    }
    private val tvWeatherForecastError by lazy {
        fragmentView.findViewById<TextView>(R.id.tv_forecast_error)
    }

    companion object {
        val TAG: String = WeatherDetailsFragment::class.java.name
        fun newInstance() = WeatherDetailsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentView = inflater.inflate(R.layout.weather_details_fragment, container, false)
        return fragmentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        observeDataChanges()
    }

    private fun setupViews() {
        rvWeatherForecast = fragmentView.findViewById(R.id.rv_weather_forecast)
        rvWeatherForecast.adapter = weatherForecastAdapter
        rvWeatherForecast.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        rvWeatherForecast.addItemDecoration(
            DividerItemDecoration(
                rvWeatherForecast.context,
                DividerItemDecoration.VERTICAL
            )
        )
        progressBar = fragmentView.findViewById(R.id.progress_bar)
    }

    private fun observeDataChanges() {
        weatherDetailsViewModel.getWeatherDetails(18.5919501, 73.7920957)
        weatherDetailsViewModel.currentWeatherLiveData.observe(
            viewLifecycleOwner,
            ResultObserver(
                hideLoading = ::hideLoading,
                showLoading = ::showLoading,
                onSuccess = ::updateCurrentWeather,
                onError = ::showCurrentWeatherErrorMessage
            )
        )
        weatherDetailsViewModel.forecastWeatherLiveData.observe(
            viewLifecycleOwner,
            ResultObserver(
                hideLoading = ::hideLoading,
                showLoading = ::showLoading,
                onSuccess = ::updateWeatherForecast,
                onError = ::showWeatherForecastErrorMessage
            )
        )
    }

    private fun hideLoading() {
        progressBar.visibility = View.INVISIBLE
    }

    private fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    private fun updateCurrentWeather(currentWeather: CurrentWeather) {
        gpCurrentWeather.visibility = View.VISIBLE
        tvPressure.text = currentWeather.pressure
        tvHumidity.text = currentWeather.humidity
        tvWindSpeed.text = currentWeather.windSpeed
        tvTemperature.text = currentWeather.temperatureInCelsius
        tvCityName.text = currentWeather.cityName
    }

    private fun updateWeatherForecast(weatherForecastDetails: List<ForecastWeather>) {
        weatherForecastAdapter.setWeatherList(weatherForecastDetails)
    }

    private fun showCurrentWeatherErrorMessage(error: String) {
        tvCurrentWeatherError.visibility = View.VISIBLE
        tvCurrentWeatherError.text = error
    }

    private fun showWeatherForecastErrorMessage(error: String) {
        tvWeatherForecastError.visibility = View.VISIBLE
        tvWeatherForecastError.text = error
    }
}
