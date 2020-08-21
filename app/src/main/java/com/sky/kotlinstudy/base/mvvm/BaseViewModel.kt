package com.sky.kotlinstudy.base.mvvm

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 *created skyHuang
 * data 2020/8/19
 **/
abstract class BaseViewModel : ViewModel() {
    /**
     * 初始化
     */
    abstract fun initState()


}