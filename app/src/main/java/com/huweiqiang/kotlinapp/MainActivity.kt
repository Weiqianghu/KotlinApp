package com.huweiqiang.kotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.huweiqiang.kotlinapp.domain.Forecast
import com.huweiqiang.kotlinapp.domain.ForecastRequest
import com.huweiqiang.kotlinapp.domain.RequestForecastCommand
import com.huweiqiang.kotlinapp.domain.WeatherData
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    private var forecastData = ArrayList<Forecast>()

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()

    }

    private fun initData() {
        forecast_list.adapter = ForecastListAdapter(forecastData)

        doAsync {
            val weatherData: WeatherData = RequestForecastCommand("101010100").execute()
            uiThread {
                forecastData.clear()
                forecastData.addAll(weatherData.forecast)
                forecast_list.adapter.notifyDataSetChanged()
            }
        }
    }

    private fun initView() {
        forecast_list.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
    }
}
