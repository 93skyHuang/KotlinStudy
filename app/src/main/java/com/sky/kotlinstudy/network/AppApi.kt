package com.sky.kotlinstudy.network

import com.sky.kotlinstudy.network.interceptor.HeaderInterceptor
import com.sky.kotlinstudy.network.interceptor.LogInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *created skyHuang
 * data 2020/8/11
 * 接口请求
 **/

val BASE_RUL = "https://www.wanandroid.com"

val Api: ApiService by lazy {
    Retrofit.Builder()
        .baseUrl(BASE_RUL)
        .client(MyOkHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)
}


private val MyOkHttpClient: OkHttpClient by lazy {
    OkHttpClient.Builder()
        .callTimeout(60_1000, TimeUnit.MILLISECONDS)
        .connectTimeout(60_1000, TimeUnit.MILLISECONDS)
        .readTimeout(60_1000, TimeUnit.MILLISECONDS)
        .writeTimeout(60_1000, TimeUnit.MILLISECONDS)
        .addInterceptor(LogInterceptor())
        .addInterceptor(HeaderInterceptor())
        .build()
}
