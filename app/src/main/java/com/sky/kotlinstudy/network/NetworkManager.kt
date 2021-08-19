package com.sky.kotlinstudy.network

import com.sky.kotlinstudy.model.Article
import com.sky.kotlinstudy.model.ArticleList
import com.sky.kotlinstudy.model.Banner
import com.sky.kotlinstudy.model.bean.BaseResponse
import com.sky.kotlinstudy.model.bean.isSuccessful
import com.sky.kotlinstudy.model.repository.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.lang.Exception
import java.util.*

/**
 *
 * @Description:    []
 * @Author:         skyHuang
 * @CreateDate:     2021/8/18 10:28
 */
class NetworkManager {

    companion object {
        val instance = NetworkManager()
    }

    suspend fun getBanner(): BaseResponse<List<Banner>> {
        return withContext(Dispatchers.IO) {
            try {
                val banner = NetworkApi.API.getHomeBanner()
                if (banner.isSuccessful()) {
                    HomeRepository.instance.saveBanners(banner.data)
                }
                banner
            } catch (e: Exception) {
                Timber.e(e)
                BaseResponse<List<Banner>>(-1, data = listOf())
            }
        }
    }
}