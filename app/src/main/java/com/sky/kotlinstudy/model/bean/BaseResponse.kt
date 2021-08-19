package com.sky.kotlinstudy.model.bean

import com.squareup.moshi.JsonClass
import timber.log.Timber

@JsonClass(generateAdapter = true)
data class BaseResponse<out T>(val errorCode: Int, val errorMsg: String="", val data: T)

private fun <T> BaseResponse<T>.isSuccessful(): Boolean {
    return errorCode == 0
}

fun <T> BaseResponse<T>.isSuccessful(isUseCommonErrorHandler: Boolean = true): Boolean {
    if (!isSuccessful() && isUseCommonErrorHandler) {
        commonErrorHandler(errorCode)
    }
    return isSuccessful()
}

fun commonErrorHandler(errorCode: Int) {
    Timber.d("commonErrorHandler errorCode=$errorCode")
}