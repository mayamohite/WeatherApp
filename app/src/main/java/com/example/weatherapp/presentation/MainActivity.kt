package com.example.weatherapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherapp.R
import dagger.hilt.android.AndroidEntryPoint
import com.example.weatherapp.presentation.weatherdetail.WeatherDetailsFragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        launchWeatherDetailsFragment()
    }

    private fun launchWeatherDetailsFragment() {
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container, WeatherDetailsFragment.newInstance()
        ).addToBackStack(WeatherDetailsFragment.TAG).commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}

