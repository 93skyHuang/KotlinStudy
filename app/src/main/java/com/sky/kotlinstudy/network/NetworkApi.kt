package com.sky.kotlinstudy.network

import com.sky.kotlinstudy.network.interceptor.HeaderInterceptor
import com.sky.kotlinstudy.network.interceptor.LogInterceptor
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 *created skyHuang
 * data 2020/8/11
 * 接口请求
 **/

val BASE_URL = "https://www.wanandroid.com"

object NetworkApi {
    val API = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(MyOkHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
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
