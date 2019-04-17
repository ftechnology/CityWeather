package com.farukhossain.tokyoweather.model

import com.google.gson.annotations.SerializedName

/**
 * Created by farukhossain on 2019/04/16.
 */
class TemperatureData {

    @SerializedName("day")
    private var day: String? = null
    @SerializedName("min")
    private var min: String? = null
    @SerializedName("max")
    private var max: String? = null
    @SerializedName("night")
    private var night: String? = null
    @SerializedName("eve")
    private var eve: String? = null
    @SerializedName("morn")
    private var morn: String? = null

    fun TemperatureData(day: String, min: String, max: String, night: String, eve: String, morn: String) {
        this.day = day
        this.min = min
        this.max = max
        this.night = night
        this.eve = eve
        this.morn = morn
    }

    fun getDay(): String? {
        return day
    }

    fun setDay(day: String) {
        this.day = day
    }

    fun getMin(): String? {
        return min
    }

    fun setMin(min: String) {
        this.min = min
    }

    fun getMax(): String? {
        return max
    }

    fun setMax(max: String) {
        this.max = max
    }

    fun getNight(): String? {
        return night
    }

    fun setNight(night: String) {
        this.night = night
    }

    fun getEve(): String? {
        return eve
    }

    fun setEve(eve: String) {
        this.eve = eve
    }

    fun getMorn(): String? {
        return morn
    }

    fun setMorn(morn: String) {
        this.morn = morn
    }

}