package com.farukhossain.tokyoweather.model

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

/**
 * Created by farukhossain on 2019/04/16.
 */
class ResponseData {

    @SerializedName("dt")
    private var dt: String? = null
    @SerializedName("temp")
    private var temp: TemperatureData? = null
    @SerializedName("weather")
    private var weather: ArrayList<WeatherData>? = null

    fun ResponseData(dt: String, temp: TemperatureData, weather: ArrayList<WeatherData>) {
        this.dt = dt
        this.temp = temp
        this.weather = weather
    }

    fun getDt(): String? {
        return dt
    }

    fun setDt(dt: String) {
        this.dt = dt
    }

    fun getTemp(): TemperatureData? {
        return temp
    }

    fun setTemp(temp: TemperatureData) {
        this.temp = temp
    }

    fun getWeather(): ArrayList<WeatherData>? {
        return weather
    }

    fun setWeather(weather: ArrayList<WeatherData>) {
        this.weather = weather
    }
}