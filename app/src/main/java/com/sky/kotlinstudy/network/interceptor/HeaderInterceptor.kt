package com.sky.kotlinstudy.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class HeaderInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val target = original.newBuilder()
        target.header("AccessType", "app")
        target.header("Token",
            "token"
        )
        return chain.proceed(target.build())
    }
}