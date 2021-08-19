package com.sky.kotlinstudy

import android.app.Application
import timber.log.Timber

/**
 *created skyHuang
 * data 2020/8/21
 **/

lateinit var skyApplication: SkyApp

class SkyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        skyApplication = this
        Timber.plant(Timber.DebugTree())
    }
}