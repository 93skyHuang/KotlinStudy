package com.sky.kotlinstudy.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sky.kotlinstudy.model.Banner

/**
 *
 * @Description:    []
 * @Author:         skyHuang
 * @CreateDate:     2021/8/6 10:55
 */
@Dao
interface DBDao {

    @Query("SELECT * FROM dbBanner")
    fun getAllBanners(): LiveData<List<DBBanner>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllBanners(dbBanners: List<DBBanner>)

    @Insert
    fun insertBanner(dbBanner: DBBanner)

    @Query("SELECT * FROM dbBanner ORDER BY id DESC LIMIT 1")
    fun getBanner(): DBBanner?

    @Query("SELECT * FROM dbBanner ORDER BY id DESC LIMIT 1")
    fun getBannerLi(): LiveData<DBBanner>

    @Query("SELECT * FROM dbBanner")
    fun getBanners(): List<DBBanner>?
}