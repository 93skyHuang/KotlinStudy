package com.sky.kotlinstudy.model.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.sky.kotlinstudy.model.Banner
import com.sky.kotlinstudy.model.bean.isSuccessful
import com.sky.kotlinstudy.model.convertToDBBanners
import com.sky.kotlinstudy.network.NetworkApi
import com.sky.kotlinstudy.room.DBBanner
import com.sky.kotlinstudy.room.SkyDataBase
import com.sky.kotlinstudy.room.convertToBanners
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber


/**
 *
 * @Description:    []
 * @Author:         skyHuang
 * @CreateDate:     2021/8/6 9:46
 */
class HomeRepository {

    companion object {
        val instance = HomeRepository()
    }

    private val dataBase = SkyDataBase.getInstance()

    var uiBanners: LiveData<List<Banner>> = Transformations.map(dataBase.daDBDao.getAllBanners()) {
        it.convertToBanners()
    }

    fun saveBanners(uiBanners: List<Banner>) {
        dataBase.daDBDao.insertAllBanners(uiBanners.convertToDBBanners())
    }
}