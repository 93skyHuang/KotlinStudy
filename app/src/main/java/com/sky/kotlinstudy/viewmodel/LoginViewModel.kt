package com.sky.kotlinstudy.viewmodel

import com.sky.kotlinstudy.base.mvvm.BaseViewModel
import me.hgj.jetpackmvvm.callback.livedata.StringLiveData

/**
 *created skyHuang
 * data 2020/8/21
 **/
class LoginViewModel : BaseViewModel() {

    var username = StringLiveData()

    var pwd = StringLiveData()
    override fun initState() {

    }
}