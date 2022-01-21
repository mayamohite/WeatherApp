package com.example.weatherapp.data.local.db.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.weatherapp.data.remote.response.ForecastResponse

@Entity(
    tableName = "DailyForecast",
)
data class DailyForecastEntity(
    @PrimaryKey
    val date: Long,
    @Embedded
    val main: MainEntity?,
    val visibility: Int?,
    @Embedded
    val wind: WindEntity?,
    val dateAndTime: String?,
    val cityKey: String,
) {
    companion object {
        fun mapToDailyForecastEntity(
            forecastResponse: ForecastResponse,
        ): List<DailyForecastEntity>? {
            if (forecastResponse.list == null) {
                return null
            }
            val dailyForecast = mutableListOf<DailyForecastEntity>()
            forecastResponse.list.forEach {
                dailyForecast.add(
                    DailyForecastEntity(
                        date = it.date ?: 0,
                        main = MainEntity(it.main),
                        visibility = it.visibility,
                        wind = WindEntity(it.wind),
                        dateAndTime = it.dateAndTime,
                        cityKey = forecastResponse.city?.name ?: ""
                    )
                )
            }
            return dailyForecast
        }
    }
}

