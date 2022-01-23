package com.example.weatherapp.presentation.utils

import android.content.Context
import android.widget.Toast
import com.example.weatherapp.BuildConfig

/**
 * Function to show toast
 */
fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

/**
 * Log messages in debug mode
 */
fun log(tag: String, message: String) {
    if (BuildConfig.DEBUG) {
        println("$tag : $message")
    }
}
