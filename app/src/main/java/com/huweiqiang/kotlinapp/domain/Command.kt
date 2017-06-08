package com.huweiqiang.kotlinapp.domain

/**
 * Created by huweiqiang on 2017/6/8.
 */

public interface Command<T> {
    fun execute(): T
}
