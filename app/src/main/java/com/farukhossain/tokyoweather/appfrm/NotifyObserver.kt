package com.farukhossain.tokyoweather.appfrm

/**
 * Created by farukhossain on 2019/04/16.
 */
interface NotifyObserver {
    abstract fun update(response: ResponseObject)
}