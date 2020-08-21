package com.sky.kotlinstudy.common

import android.app.Activity
import android.content.Intent
import android.os.Bundle

/**
 *created skyHuang
 * data 2020/8/19
 *
 **/

fun Activity.navNextPage(
    activity: Class<*>,
    bundle: Bundle? = null,
    requestCode: Int? = null,
    login: Boolean = false
): Activity {
    val intent = Intent(this, activity)
    bundle?.let { intent.putExtras(it) }
    requestCode?.let {
        startActivityForResult(intent, it)
    } ?: run {
        startActivity(intent)
    }
    return this
}
