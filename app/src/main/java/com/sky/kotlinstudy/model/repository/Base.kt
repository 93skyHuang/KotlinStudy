package com.sky.kotlinstudy.model.repository

import com.sky.kotlinstudy.model.bean.BaseResponse
import com.sky.kotlinstudy.network.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope

/**
 *
 * @Description:    []
 * @Author:         skyHuang
 * @CreateDate:     2021/6/23 17:32
 */
open class Base {
    suspend fun <T : Any> safeApiCall(call: suspend () -> Result<T>, errorMessage: String): Result<T> {
        return try {
            call()
        } catch (e: Exception) {
            // An exception was thrown when calling the API so we're converting this to an IOException
            Result.Error(Exception(errorMessage, e))
        }
    }

    suspend fun <T : Any> executeResponse(response: BaseResponse<T>): Result<T> {
        return coroutineScope {
            if (response.errorCode == -1) {
                Result.Error(Exception(response.errorMsg))
            } else {
                Result.Success(response.data)
            }
        }
    }

}