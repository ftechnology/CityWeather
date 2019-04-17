package com.farukhossain.tokyoweather.activity

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.farukhossain.weeklyweather.R
import com.farukhossain.tokyoweather.adapter.WeatherListAdapter
import com.farukhossain.tokyoweather.appfrm.*
import com.farukhossain.tokyoweather.model.IconMapingModel
import com.farukhossain.tokyoweather.model.ResponseData
import java.util.ArrayList

/**
 * Created by farukhossain on 2019/04/17.
 */
class MainActivity : BaseActivity() {

    private var mRecyclerView: RecyclerView? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null
    private var mAdapter: WeatherListAdapter? = null

    private var tv_today: TextView? = null
    private var tv_temp_avg:TextView? = null
    private var tv_min:TextView? = null
    private var tv_status:TextView? = null
    private var iv_weather: ImageView? = null
    private var mProgressDoalog: ProgressDialog? = null


    override fun createView(savedInstanceState: Bundle?) {
        this.setContentView(R.layout.activity_main)
        initUI()
        setupRecycleView()
    }

    override fun createAdapter() {
        mAdapter = WeatherListAdapter()
        mAdapter?.setContext(this)
        mAdapter?.setmNotifyObserver(this)
    }

    override fun loadData() {
        if (!NetworkUtill.isNetworkAvailable(this)) {
            Toast.makeText(this, getString(R.string.STR_NO_INTERNET), Toast.LENGTH_LONG).show()
            return
        }
        mAdapter?.loadData()
    }

    override fun doUpdateRequest(response: ResponseObject) {
        if (response != null) {
            val code = response.getResponseCode()
            if (code == Constants.CODE_SUCCESS) {
                val message = response.getResponseMsg()

                if (message == Constants.MSG_LOAD_START) {
                    showProgressDialog()
                }

                if (message == Constants.MSG_LOAD_FINISH) {
                    hideProgressDialog()
                    generateCollapseViewData(response.getDataObject() as ArrayList<ResponseData>)
                }
            }

            if (code == Constants.CODE_FAIL) {
                hideProgressDialog()
            }
        }
    }


    private fun initUI() {
        val toolBar = findViewById<View>(R.id.collapsing_toolbar) as Toolbar
        setSupportActionBar(toolBar)
        supportActionBar!!.setTitle("")

        mRecyclerView = findViewById<RecyclerView>(R.id.weather_recycler_view)
        mRecyclerView?.setAdapter(mAdapter)

        tv_today = findViewById<TextView>(R.id.tv_today)
        tv_temp_avg = findViewById<TextView>(R.id.tv_avg_temp)
        tv_min = findViewById<TextView>(R.id.tv_min_temp)
        tv_status = findViewById<TextView>(R.id.tv_today_status)
        iv_weather = findViewById<ImageView>(R.id.iv_today_status)
    }

    private fun setupRecycleView() {
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView?.setHasFixedSize(true)

        mLayoutManager = LinearLayoutManager(this)
        mRecyclerView?.setLayoutManager(mLayoutManager)
        mRecyclerView?.setItemAnimator(DefaultItemAnimator())
    }

    private fun generateCollapseViewData(dataList: ArrayList<ResponseData>?) {
        if (dataList != null && dataList.size > 0) {
            val data = dataList[0]
            val temperatureData = data.getTemp()
            tv_today?.setText(Convert.getTodayDate(Convert.toLong(data.getDt().toString())))
            tv_temp_avg?.setText("" + Convert.toInt(temperatureData?.getDay().toString()) + 0x00B0.toChar())
            tv_min?.setText("" + Convert.toInt(temperatureData?.getMin().toString()) + 0x00B0.toChar())

            val weatherData = data.getWeather()
            if (weatherData != null && weatherData!!.size > 0) {
                tv_status?.setText(weatherData!!.get(0).getMain())
                iv_weather?.setImageResource(IconMapingModel.getInstance()?.getArtWeatherIcon(weatherData[0].getDescription().toString())!!)
            }

        }
    }

    private fun showProgressDialog() {
        mProgressDoalog = ProgressDialog(this@MainActivity)
        mProgressDoalog?.setMessage(getString(R.string.STR_LOADING))
        mProgressDoalog?.show()
    }

    private fun hideProgressDialog() {
        if (mProgressDoalog != null && mProgressDoalog!!.isShowing()) {
            mProgressDoalog?.dismiss()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)
        return true
    }
}