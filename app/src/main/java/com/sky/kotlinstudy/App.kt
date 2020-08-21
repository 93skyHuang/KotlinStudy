package com.sky.kotlinstudy

import android.app.Application

/**
 *created skyHuang
 * data 2020/8/21
 **/
class App : Application() {
    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}