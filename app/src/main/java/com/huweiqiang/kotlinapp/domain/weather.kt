package com.huweiqiang.kotlinapp.domain


/**
 * Created by huweiqiang on 2017/6/8.
 */

data class Weather(val wthr: String, val smPic: String, val wp: String, val wd: String, val notice: String)

data class Forecast(val date: String, val sunrise: String, val high: String, val low: String, val sunset: String, val night: com.huweiqiang.kotlinapp.domain.Weather, val day: com.huweiqiang.kotlinapp.domain.Weather, val aqi: String)

data class Env(val pm25: String, val suggest: String)

data class WeatherData(val forecast: List<Forecast>, val evn: Env)
