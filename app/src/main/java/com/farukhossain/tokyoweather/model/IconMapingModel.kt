package com.farukhossain.tokyoweather.model

import com.farukhossain.weeklyweather.R

/**
 * Created by farukhossain on 2019/04/16.
 */
class IconMapingModel {

    companion object {
        internal val STR_CLEAR = "sky is clear"
        internal val STR_CLOUDY = "overcast clouds"
        internal val STR_FOG = "fog"
        internal val STR_LIGHT_CLOUDS = "few clouds"
        internal val STR_RAIN = "moderate rain"
        internal val STR_LIGHT_RAIN = "light rain"
        internal val STR_BROKEN_CLOUDS = "broken clouds"
        internal val STR_SCATTERED = "scattered clouds"
        internal val SRT_HEAVY_RAIN = "heavy intensity rain"
        internal val SRT_THUNDER_RAIN = "thunder storm with light rain"
        internal val SRT_THUNDER_STORM = "thunder storm"
        internal val SRT_SNOW = "snow"
        internal val SRT_LIGHT_SNOW = "light snow"

        private var iconMapingModel: IconMapingModel? = null

        fun getInstance(): IconMapingModel? {
            if (iconMapingModel == null) {
                iconMapingModel = IconMapingModel()
            }
            return iconMapingModel
        }
    }

    fun getWeatherIcon(status: String): Int {
        var iconId = R.drawable.ic_clear

        when (status) {
            STR_CLEAR -> iconId = R.drawable.ic_clear
            STR_CLOUDY -> iconId = R.drawable.ic_cloudy
            STR_FOG -> iconId = R.drawable.ic_fog
            STR_LIGHT_CLOUDS -> {
                iconId = R.drawable.ic_light_clouds
                iconId = R.drawable.ic_light_clouds
                iconId = R.drawable.ic_light_clouds
            }

            STR_BROKEN_CLOUDS -> {
                iconId = R.drawable.ic_light_clouds
                iconId = R.drawable.ic_light_clouds
            }

            STR_SCATTERED -> iconId = R.drawable.ic_light_clouds

            STR_RAIN -> iconId = R.drawable.ic_rain

            STR_LIGHT_RAIN -> iconId = R.drawable.ic_light_rain

            SRT_HEAVY_RAIN -> {
                iconId = R.drawable.ic_storm
                iconId = R.drawable.ic_storm
                iconId = R.drawable.ic_storm
            }
            SRT_THUNDER_RAIN -> {
                iconId = R.drawable.ic_storm
                iconId = R.drawable.ic_storm
            }
            SRT_THUNDER_STORM -> iconId = R.drawable.ic_storm

            SRT_SNOW -> {
                iconId = R.drawable.ic_snow
                iconId = R.drawable.ic_storm
            }
            SRT_LIGHT_SNOW -> iconId = R.drawable.ic_storm
        }

        return iconId
    }

    fun getArtWeatherIcon(status: String): Int {
        var iconId = R.drawable.art_clear

        when (status) {
            STR_CLEAR -> iconId = R.drawable.art_clear
            STR_CLOUDY -> iconId = R.drawable.art_clouds
            STR_FOG -> iconId = R.drawable.art_fog
            STR_LIGHT_CLOUDS -> {
                iconId = R.drawable.art_light_clouds
                iconId = R.drawable.art_light_clouds
                iconId = R.drawable.art_light_clouds
            }

            STR_BROKEN_CLOUDS -> {
                iconId = R.drawable.art_light_clouds
                iconId = R.drawable.art_light_clouds
            }

            STR_SCATTERED -> iconId = R.drawable.art_light_clouds
            STR_RAIN -> iconId = R.drawable.art_rain
            STR_LIGHT_RAIN -> iconId = R.drawable.art_light_rain
            SRT_HEAVY_RAIN -> {
                iconId = R.drawable.art_storm
                iconId = R.drawable.art_storm
                iconId = R.drawable.art_storm
            }
            SRT_THUNDER_RAIN -> {
                iconId = R.drawable.art_storm
                iconId = R.drawable.art_storm
            }
            SRT_THUNDER_STORM -> iconId = R.drawable.art_storm

            SRT_SNOW -> {
                iconId = R.drawable.art_snow
                iconId = R.drawable.art_snow
            }
            SRT_LIGHT_SNOW -> iconId = R.drawable.art_snow
        }
        return iconId
    }



}