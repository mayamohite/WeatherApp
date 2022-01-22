package com.example.weatherapp.data.local.db.utils

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

const val FAHRENHEIT_UNIT = "°F"
const val CELSIUS_UNIT = "°C"
const val PRESSURE_UNIT = "mBar"
const val HUMIDITY_UNIT = "%"
const val DAY_FORMAT = "EEEE"
const val DATE_FORMAT = "yyyy-MM-dd"
const val NO_DATA_SYMBOL = " - "

fun celsiusToFahrenheit(temperature: Double?): String {
    return if (temperature == null) {
        NO_DATA_SYMBOL
    } else {
        val fahrenheitTemp = "%.2f".format(((temperature * 9 / 5) + 32))
        "$fahrenheitTemp$FAHRENHEIT_UNIT"
    }
}

fun temperatureInCelsius(temperature: Double?): String {
    return if (temperature == null) {
        NO_DATA_SYMBOL
    } else {
        "$temperature$CELSIUS_UNIT"
    }
}

fun humidity(humidity: Int?): String {
    return if (humidity == null) {
        NO_DATA_SYMBOL
    } else {
        "$humidity$HUMIDITY_UNIT"
    }
}

fun pressure(pressure: Double?): String {
    return if (pressure == null) {
        NO_DATA_SYMBOL
    } else {
        "$pressure $PRESSURE_UNIT"
    }
}

fun getDay(dateTime: String): String {
    val dateFormat: DateFormat = SimpleDateFormat(DATE_FORMAT)
    val formattedDate: Date = dateFormat.parse(dateTime)
    return SimpleDateFormat(DAY_FORMAT).format(formattedDate)
}

fun getTime(datetime: String?): String? {
    return datetime?.substringAfter(" ")?.substringBeforeLast(":")
}

fun getDateFromDateAndTime(datetime: String?): String {
    return datetime?.substringBefore(" ") ?: " "
}
