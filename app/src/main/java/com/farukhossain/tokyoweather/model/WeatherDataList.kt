package com.farukhossain.tokyoweather.model

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

/**
 * Created by farukhossain on 2019/04/16.
 */
class WeatherDataList {

    @SerializedName("list")
    private var weatherList: ArrayList<ResponseData>? = null

    fun getWeatherArrayList(): ArrayList<ResponseData>? {
        return weatherList
    }

    fun setEmployeeArrayList(weatherArrayList: ArrayList<ResponseData>) {
        this.weatherList = weatherArrayList
    }
}