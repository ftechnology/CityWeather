package com.farukhossain.tokyoweather.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.farukhossain.weeklyweather.R
import com.farukhossain.tokyoweather.appfrm.*
import com.farukhossain.tokyoweather.model.IconMapingModel
import com.farukhossain.tokyoweather.model.ResponseData
import com.farukhossain.tokyoweather.model.WeatherDataList
import com.farukhossain.tokyoweather.webservice.GetWeatherDataService
import com.farukhossain.tokyoweather.webservice.RetrofitClientInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

/**
 * Created by farukhossain on 2019/04/17.
 */
class WeatherListAdapter : AbsRecycleViewBaseAdapter() {

    private var mDataList: ArrayList<ResponseData>? = null

    companion object {
        val STR_TODAY = "Today"
        val STR_TOMORROW = "Tomorrow"
    }

    fun setmNotifyObserver(notifyObserver: NotifyObserver) {
        this.mNotifyObserver = notifyObserver
    }

    fun setDataList(dataList: ArrayList<ResponseData>) {
        this.mDataList = dataList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // create a new view
        val itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_layout, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, i: Int) {
        val data = mDataList?.get(i)

        val temperatureData = data?.getTemp()
        holder.day?.setText(getFormatedDate(i, data!!))
        holder.temp_avg?.setText("" + Convert.toInt(temperatureData?.getDay().toString()) + 0x00B0.toChar())
        holder.temp_min?.setText("" + Convert.toInt(temperatureData?.getMin().toString()) + 0x00B0.toChar())

        val weatherData = data?.getWeather()
        if (weatherData != null && weatherData.size > 0) {
            holder.status?.setText(weatherData[0].getMain())
            holder.imageView?.setImageResource(IconMapingModel.getInstance()?.getWeatherIcon(weatherData[0].getDescription().toString())!!)
        }
    }


    private fun getFormatedDate(pos: Int, data: ResponseData): String {
        var date = ""
        if (pos == 0) {
            date = STR_TOMORROW
        } else if (pos > 0 && pos < 7) {
            date = Convert.getWeekDayName(Convert.toLong(data?.getDt().toString()))
        } else {
            date = Convert.getYearDay(Convert.toLong(data?.getDt().toString()))
        }

        return date
    }

    /*Method to generate List of employees using RecyclerView with custom adapter*/
    private fun generateAdapterDataList(dataList: ArrayList<ResponseData>?) {
        dataList!!.removeAt(0)
        mDataList = dataList
        notifyDataSetChanged()
    }

    override fun loadData(): ResponseObject {

        val responseObj = ResponseObject(0, "", null)

        val service = RetrofitClientInstance.getRetrofitInstance()?.create(GetWeatherDataService::class.java)

        /*Call the method with parameter in the interface to get the employee data*/
        val call = service?.getAllData()

        /*Log the URL called*/
        val REQ_URL = call?.request()?.url().toString()
        LogUtil.d("URL Called", REQ_URL + "")
        if (mNotifyObserver != null)
            mNotifyObserver!!.update(ResponseObject(Constants.CODE_SUCCESS, Constants.MSG_LOAD_START, null))

        call?.enqueue(object : Callback<WeatherDataList> {
            override fun onResponse(call: Call<WeatherDataList>, response: Response<WeatherDataList>) {

                if (response.isSuccessful) {
                    if (mNotifyObserver != null)
                        mNotifyObserver!!.update(ResponseObject(Constants.CODE_SUCCESS, Constants.MSG_LOAD_FINISH, response.body().getWeatherArrayList()))
                    generateAdapterDataList(response.body().getWeatherArrayList())
                } else {
                    if (mNotifyObserver != null)
                        mNotifyObserver!!.update(ResponseObject(Constants.CODE_FAIL, "", null))
                    Toast.makeText(mContext, mContext?.getString(R.string.STR_FETCH_FAIL), Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<WeatherDataList>, t: Throwable) {
                if (mNotifyObserver != null)
                    mNotifyObserver!!.update(ResponseObject(Constants.CODE_FAIL, "", null))
                Toast.makeText(mContext, mContext?.getString(R.string.STR_FETCH_FAIL), Toast.LENGTH_SHORT).show()
            }
        })

        return responseObj
    }

    override fun getItemCount(): Int {
        return if (mDataList == null) 0 else mDataList!!.size
    }
}