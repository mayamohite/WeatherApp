package com.example.weatherapp.data.api.response

import com.google.gson.annotations.SerializedName

data class ForecastResponse(
    val city: City?,
    @SerializedName("list")
    val list: List<ForecastDetails>?
)

data class ForecastDetails(
    @SerializedName("dt")
    val date: Long? = null,
    val main: Main? = null,
    val visibility: Int? = null,
    val wind: Wind? = null,
    @SerializedName("dt_txt")
    val dateAndTime: String? = null
)

data class City(
    val id: Int? = null,
    val name: String? = null,
    @SerializedName("coord")
    val coordinates: Coordinates,
    @SerializedName("country")
    val countryName: String? = null,
    val timezone: Long? = null,
    @SerializedName("sunrise")
    val sunriseTime: Long? = null,
    @SerializedName("sunset")
    val sunsetTime: Long? = null,
)
