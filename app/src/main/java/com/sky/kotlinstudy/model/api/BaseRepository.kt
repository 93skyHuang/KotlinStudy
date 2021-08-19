package com.sky.kotlinstudy.model.api

import com.sky.kotlinstudy.model.bean.BaseResponse
import com.sky.kotlinstudy.network.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope

/**
 * 数据返回
 */
open class BaseRepository {

    suspend fun <T : Any> safeApiCall(call: suspend () -> Result<T>, errorMessage: String): Result<T> {
        return try {
            call()
        } catch (e: Exception) {
            // An exception was thrown when calling the API so we're converting this to an IOException
            Result.Error(Exception(errorMessage, e))
        }
    }

//    suspend fun <T : Any> executeResponse(response: BaseResponse<T>, successBlock: (suspend CoroutineScope.() -> Unit)? = null,
//                                          errorBlock: (suspend CoroutineScope.() -> Unit)? = null): Result<T> {
//     return coroutineScope {
//              Result.Success(response.data)
//
////            if (response.errorCode == -1) {
////                errorBlock?.let { it() }
////                Result.Error(Exception(response.errorMsg))
////            } else {
////                successBlock?.let { it() }
////                Result.Success(response.data)
////            }
//        }
//    }


}