package com.farukhossain.tokyoweather.appfrm

import com.farukhossain.tokyoweather.adapter.WeatherListAdapter
import java.text.NumberFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by farukhossain on 2019/04/16.
 */
class Convert {
    companion object {
        /**
         * Return the integer from string.
         *
         * @param value
         * @return
         */
        fun toInt(value: String): Int {
            try {
                return NumberFormat.getInstance().parse(value).toInt()
            } catch (e: ParseException) {

            }

            return 0
        }

        /**
         * Return the long from string.
         *
         * @param value
         * @return
         */
        fun toLong(value: String): Long {
            try {
                return java.lang.Long.parseLong(value)
            } catch (e: NumberFormatException) {

            }

            return 0
        }

        fun getYearDay(timestamp: Long): String {
            val format = SimpleDateFormat("MMMM dd, EEE", Locale.US)
            return format.format(Date(timestamp * 1000L))
        }

        fun getWeekDayName(timestamp: Long): String {
            TimeZone.setDefault(TimeZone.getTimeZone("Japan/Tokyo"))
            val format = SimpleDateFormat("EEEE", Locale.US)
            return format.format(Date(timestamp * 1000L))
        }

        fun getTodayDate(timestamp: Long): String {
            val cal = Calendar.getInstance(Locale.US)
            cal.timeInMillis = timestamp * 1000L
            val now = Date()
            val simpleDateformat = SimpleDateFormat("MMMM dd", Locale.US)
            val today = simpleDateformat.format(now)
            return WeatherListAdapter.STR_TODAY + ", " + today
        }
    }


}