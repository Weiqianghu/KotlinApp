package com.huweiqiang.kotlinapp.domain

/**
 * Created by huweiqiang on 2017/6/8.
 */

class RequestForecastCommand(val cityCode: String) : Command<WeatherData> {
    override fun execute(): WeatherData {
        val forecastRequest = ForecastRequest(cityCode)
        return forecastRequest.execute()
    }

}