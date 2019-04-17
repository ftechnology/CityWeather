package com.farukhossain.tokyoweather.appfrm

/**
 * Created by farukhossain on 2019/04/16.
 */
class Constants {

    companion object {
        const val CODE_SUCCESS = 100
        const val CODE_FAIL = -100
        const val MSG_LOAD_START = "MSG_LOAD_START"
        const val MSG_LOAD_FINISH = "MSG_LOAD_FINISH"

        const val CITY_ID : String = "1850147"  // TOKYO CITY ID
        const val API_KEY : String = "ce10471789a42da7c7fe792fef884ad6"

        const val CNT_DAYS : Int = 16 // number of days returned (from 1 to 16)

        //For temperature in Fahrenheit use units=imperial
        //For temperature in Celsius use units=metric
        //Temperature in Kelvin is used by default,
        const val TEMP_UNIT : String = "metric"
        const val REQUEST_PARAM : String = "daily?id=$CITY_ID&cnt=$CNT_DAYS&APPID=$API_KEY&units=$TEMP_UNIT"
    }
}