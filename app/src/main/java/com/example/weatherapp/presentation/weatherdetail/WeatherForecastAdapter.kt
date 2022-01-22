package com.example.weatherapp.presentation.weatherdetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.domain.model.ForecastWeather
import javax.inject.Inject

class WeatherForecastAdapter @Inject constructor(
) : ListAdapter<ForecastWeather, WeatherForecastAdapter.ViewHolder>(DiffCallback()) {

    private var forecastList: List<ForecastWeather>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewHolder = layoutInflater.inflate(R.layout.weather_forecast_row, parent, false)
        return ViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val weather = forecastList?.get(position)
        holder.tvDay.text = weather?.day
        holder.tvMaxTemp.text = weather?.maxTemp
        holder.tvMinTemp.text = weather?.minTemp
    }

    override fun getItemCount(): Int {
        return forecastList?.size ?: 0
    }

    fun setWeatherList(forecastList: List<ForecastWeather>?) {
        this.forecastList = forecastList
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvMaxTemp: TextView = itemView.findViewById(R.id.tv_max_temp)
        val tvMinTemp: TextView = itemView.findViewById(R.id.tv_min_temp)
        val tvDay: TextView = itemView.findViewById(R.id.tv_day)
    }
}

private class DiffCallback : DiffUtil.ItemCallback<ForecastWeather>() {

    override fun areItemsTheSame(oldItem: ForecastWeather, newItem: ForecastWeather) =
        oldItem.day == newItem.day

    override fun areContentsTheSame(oldItem: ForecastWeather, newItem: ForecastWeather) =
        oldItem == newItem
}
