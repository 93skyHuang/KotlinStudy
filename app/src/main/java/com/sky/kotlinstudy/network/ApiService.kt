package com.sky.kotlinstudy.network

import com.sky.kotlinstudy.network.bean.BaseResponse
import com.sky.kotlinstudy.network.bean.TestBody
import retrofit2.Call
import retrofit2.http.GET

/**
 *created skyHuang
 * data 2020/8/11
 *
 **/
interface ApiService {

    /**
     * get 请求---------
     */
    /**
     * 测试接口
     */
    @GET("wxarticle/chapters/json")
    fun test(): Call<TestBody>
}