package com.huweiqiang.kotlinapp.domain

import com.google.gson.Gson
import java.net.URL

/**
 * Created by huweiqiang on 2017/6/8.
 */

public class ForecastRequest(val cityCode: String) {
    companion object {
        private val url = "http://zhwnlapi.etouch.cn/Ecalender/api/v2/weather?date=20160105&citykey="
    }

    fun execute(): WeatherData {
        val response = URL(url + cityCode).readText()
        return Gson().fromJson(response, WeatherData::class.java)
    }
}
