package com.farukhossain.tokyoweather.webservice

import com.farukhossain.tokyoweather.appfrm.Constants
import com.farukhossain.tokyoweather.model.WeatherDataList
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by farukhossain on 2019/04/16.
 */
interface GetWeatherDataService {

    @GET(Constants.REQUEST_PARAM)
    abstract fun getAllData(): Call<WeatherDataList>
}