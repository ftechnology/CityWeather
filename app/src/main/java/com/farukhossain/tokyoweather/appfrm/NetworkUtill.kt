package com.farukhossain.tokyoweather.appfrm

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * Created by farukhossain on 2019/04/16.
 */
class NetworkUtill {

    companion object {
        /**
         * This method check if network is avilable or not
         *
         * @param context
         * @return
         */
        fun isNetworkAvailable(context: Context): Boolean {
            val activeNetworkInfo = getNetworkInfo(context)
            return activeNetworkInfo != null && activeNetworkInfo.isConnected
        }

        /**
         * Get the network info
         *
         * @param context
         * @return
         */
        fun getNetworkInfo(context: Context): NetworkInfo? {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return cm.activeNetworkInfo
        }
    }


}