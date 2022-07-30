package com.mirtneg.weatherapplication

import android.app.ActionBar
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.WindowCompat
import com.mirtneg.weatherapplication.databinding.ActivityMainBinding
import kotlin.math.min

class MainActivity : AppCompatActivity() {

    private lateinit var main_constraint_layout : ConstraintLayout
    private lateinit var today_tv : TextView
    private lateinit var tomorrow_tv : TextView
    private lateinit var weather_image_iv : ImageView
    private lateinit var weather_text_tv : TextView
    private lateinit var temp_tv : TextView
    private lateinit var celsius_tv : TextView
    private lateinit var max_temp_tv : TextView
    private lateinit var min_temp_tv : TextView
    private lateinit var humidity_tv : TextView
    private lateinit var wind_tv : TextView
    private lateinit var precipitation_tv : TextView


    val todayWeatherData = WeatherData(
        0, 25, 10, 32, 8, 25, 12
    )

    val tomorrowWeatherData = WeatherData(
        1, 15, 5, 20, 2, 12, 66
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        setContentView(R.layout.activity_main)
        initUI()

        today_tv.setOnClickListener {
            showWeather(todayWeatherData)
        }

        tomorrow_tv.setOnClickListener {
            showWeather(tomorrowWeatherData)
        }


    }

    private fun initUI() {
        main_constraint_layout = findViewById(R.id.main_constraint_layout)
        today_tv = findViewById(R.id.today_tv)
        tomorrow_tv = findViewById(R.id.tomorrow_tv)
        weather_image_iv = findViewById(R.id.weather_image_iv)
        weather_text_tv = findViewById(R.id.weather_text_tv)
        temp_tv = findViewById(R.id.temp_tv)
        celsius_tv = findViewById(R.id.celsius_tv)
        max_temp_tv = findViewById(R.id.max_temp_tv)
        min_temp_tv = findViewById(R.id.min_temp_tv)
        humidity_tv = findViewById(R.id.humidity_tv)
        wind_tv = findViewById(R.id.wind_tv)
        precipitation_tv = findViewById(R.id.precipitation_tv)

    }

    private fun showWeather(weatherData: WeatherData) {
        temp_tv.text = weatherData.temp.toString()
        max_temp_tv.text = getString(R.string.upDownTemp,weatherData.tempMax)
        min_temp_tv.text = getString(R.string.upDownTemp,weatherData.tempMin)
        humidity_tv.text = "${weatherData.humidity}%"
        wind_tv.text = getString(R.string.wind_speed,weatherData.wind)
        precipitation_tv.text = getString(R.string.precipitation,weatherData.precipitation)

        when (weatherData.condition) {
            0 -> {
                weather_image_iv.setImageResource(R.drawable.ic_image_partlycloudy)
                weather_text_tv.text = "Sunny"
                main_constraint_layout.background = resources.getDrawable(R.drawable.gradient_sunny)
                today_tv.background = resources.getDrawable(R.drawable.rounded_corner)
                tomorrow_tv.background = resources.getDrawable(R.drawable.normal_background)
            }

            1 -> {
                weather_image_iv.setImageResource(R.drawable.ic_image_thunderstorm)
                weather_text_tv.text = "Rainy"
                main_constraint_layout.background= resources.getDrawable(R.drawable.gradient_rainy)
                today_tv.background = resources.getDrawable(R.drawable.normal_background)
                tomorrow_tv.background = resources.getDrawable(R.drawable.rounded_corner)

            }
            else -> println("Error panic!")
        }
    }
}