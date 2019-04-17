package com.farukhossain.tokyoweather.appfrm

import android.app.Application

/**
 * Created by farukhossain on 2019/04/16.
 */
class BaseApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        init();
    }

    override fun onTerminate() {
        super.onTerminate()
    }

    fun init(){

    }

}