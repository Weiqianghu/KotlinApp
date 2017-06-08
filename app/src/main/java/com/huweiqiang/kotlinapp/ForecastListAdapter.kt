package com.huweiqiang.kotlinapp

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.huweiqiang.kotlinapp.domain.Forecast

/**
 * Created by huweiqiang on 2017/6/8.
 */

class ForecastListAdapter(val items: List<Forecast>) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(items[position]) {
            holder.textView.text = "$date - ${day.wthr} - ${day.notice}"
        }
    }

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}
