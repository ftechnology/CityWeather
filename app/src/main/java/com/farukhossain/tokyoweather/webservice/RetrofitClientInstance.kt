package com.farukhossain.tokyoweather.webservice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by farukhossain on 2019/04/17.
 */
class RetrofitClientInstance {

    //Open weather map API documentation.
    //https://openweathermap.org/forecast16

    companion object {
        private var retrofit: Retrofit? = null
        private val BASE_URL = "http://api.openweathermap.org/data/2.5/forecast/"

        fun getRetrofitInstance(): Retrofit? {
            if (retrofit == null) {
                retrofit = retrofit2.Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return retrofit
        }
    }

}