package com.example.weatherapp.data.api.response

import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    val visibility: Int? = null,
    val timezone: Int? = null,
    val main: Main? = null,
    val sys: Sys? = null,
    @SerializedName("dt")
    val datetime: Int? = null,
    val base: String? = null,
    val id: Int? = null,
    val cod: Int? = null,
    val name: String? = null,
    @SerializedName("coord")
    val coordinates: Coord? = null,
    val wind: Wind? = null
)

data class Coord(
    @SerializedName("lon")
    val longitude: Double?,
    @SerializedName("lat")
    val latitude: Double?,
)

data class Wind(
    @SerializedName("deg")
    val degree: Double? = null,
    val speed: Double? = null,
    val gust: Double? = null,
)

data class Sys(
    val country: String? = null,
    val sunriseTime: Long? = null,
    val sunsetTime: Long? = null,
)

data class Main(
    @SerializedName("temp")
    val temperature: Double? = null,
    @SerializedName("temp_min")
    val minTemperature: Double? = null,
    @SerializedName("temp_max")
    val maxTemperature: Double? = null,
    val pressure: Double? = null,
    val humidity: Int? = null,
)
