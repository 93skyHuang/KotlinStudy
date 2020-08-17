package com.sky.kotlinstudy.network.bean

import java.util.*

/**
 *created skyHuang
 * data 2020/8/13
 **/
abstract class BaseResponse<T> {
    //"errorCode":0,"errorMsg":""
    var errorCode = 0
    var errorMsg = ""
    lateinit var data: List<T>
}