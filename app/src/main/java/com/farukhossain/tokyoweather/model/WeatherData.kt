package com.farukhossain.tokyoweather.model

import com.google.gson.annotations.SerializedName

/**
 * Created by farukhossain on 2019/04/16.
 */
class WeatherData {

    @SerializedName("main")
    private var main: String? = null
    @SerializedName("description")
    private var description: String? = null

    fun WeatherData(main: String, description: String) {
        this.main = main
        this.description = description
    }

    fun getMain(): String? {
        return main
    }

    fun setMain(main: String) {
        this.main = main
    }

    fun getDescription(): String? {
        return description
    }

    fun setDescription(description: String) {
        this.description = description
    }
}