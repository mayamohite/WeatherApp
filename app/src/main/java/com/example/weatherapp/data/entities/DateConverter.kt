package com.example.weatherapp.data.entities

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

class DateConverter {

    @TypeConverter
    fun fromDate(date: Date): String {
        return SimpleDateFormat("EEE, dd MMM", Locale.getDefault()).format(date)
    }

    @TypeConverter
    fun toDate(date: String): Date {
        return SimpleDateFormat("yyyy-MM-dd").parse(date)
    }
}