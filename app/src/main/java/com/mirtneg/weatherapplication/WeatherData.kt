package com.mirtneg.weatherapplication

data class WeatherData (
    val condition: Int,
    val temp: Int,
    val tempMin: Int,
    val tempMax: Int,
    val wind: Int,
    val humidity: Int,
    val precipitation: Int
)
