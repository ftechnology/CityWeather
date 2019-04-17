package com.farukhossain.tokyoweather.appfrm

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.farukhossain.weeklyweather.R

/**
 * Created by farukhossain on 2019/04/16.
 */
class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    public var day: TextView ? = null
    public var status:TextView ? = null
    public var temp_avg:TextView ? = null
    public var temp_min:TextView ? = null
    public var imageView: ImageView ? = null

    val viewHolder = ViewHolder(itemView)

    fun ViewHolder(view: View) {
        day = view.findViewById<View>(R.id.tv_day) as TextView
        status = view.findViewById<View>(R.id.tv_status) as TextView
        temp_avg = view.findViewById<View>(R.id.tv_temp_avg) as TextView
        temp_min = view.findViewById<View>(R.id.tv_temp_min) as TextView
        imageView = view.findViewById<View>(R.id.iv_status) as ImageView
    }

}