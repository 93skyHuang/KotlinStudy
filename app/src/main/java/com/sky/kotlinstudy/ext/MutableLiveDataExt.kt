package com.sky.kotlinstudy.ext

import android.os.Looper
import androidx.lifecycle.MutableLiveData

/**
 *
 * @Description:    [MutableLiveData 的扩展函数]
 * @Author:         skyHuang
 * @CreateDate:     2021/8/18 10:17
 */
/**
 * 将value值切换到ui线程
 */
fun <T> MutableLiveData<T>.setValueToUIThread(value: T) {
    sendValue(value, Looper.getMainLooper() != Looper.myLooper())
}

/**
 * LiveData分发
 * @param post 是否用postValue()；true->通过任务(Runnable)的方式在主线程中更新数据
 * @param value 分发的value
 * setValue()只能在主线程中调用，postValue()可以在任何线程中调用。
 */

fun <T> MutableLiveData<T>.sendValue(value: T, post: Boolean = false) {
    if (post) postValue(value)
    else setValue(value)
}