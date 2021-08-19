package com.sky.kotlinstudy.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import okio.Buffer
import timber.log.Timber
import java.io.IOException
import java.nio.charset.StandardCharsets

class LogInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val requestBody = request.body()
        var reqBody: String? = null
        if (requestBody != null) {
            val buffer = Buffer()
            requestBody.writeTo(buffer)
            var charset = StandardCharsets.UTF_8
            val contentType = requestBody.contentType()
            if (contentType != null) {
                charset = contentType.charset(charset)
            }
            reqBody = buffer.readString(charset!!)
        }
        val logRequestFormat = "App 发送请求%nmethod：%s%nurl：%s%nheaders: %s%nbody：%s"
        val req = String.format(
            logRequestFormat,
            request.method(),
            request.url(),
            request.headers(),
            reqBody
        )
        Timber.v(req)
        val t1 = System.nanoTime()
        val response = chain.proceed(request)
        val t2 = System.nanoTime()
        val mediaType = response.body()!!.contentType()
        val content = response.body()!!.string()
        val logResponseFormat = "App 响应请求%nurl：%s 耗时：%.1fms%n%s%n%s"
        val res = String.format(
            logResponseFormat,
            response.request().url(),
            (t2 - t1) / 1e6,
            response.headers(),
            content
        )
        Timber.i(res)
        return response.newBuilder()
            .body(ResponseBody.create(mediaType, content))
            .build()
    }
}