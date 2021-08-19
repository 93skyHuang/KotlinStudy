package com.sky.kotlinstudy.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sky.kotlinstudy.skyApplication

/**
 *
 * @Description:    []
 * @Author:         skyHuang
 * @CreateDate:     2021/8/6 10:58
 */
@Database(version = 1, entities = [DBBanner::class])
abstract class SkyDataBase : RoomDatabase() {
    abstract val daDBDao: DBDao

    companion object {
        @Volatile
        private var INSTANCE: SkyDataBase? = null

        fun getInstance(context: Context = skyApplication): SkyDataBase {
            var database = INSTANCE
            if (database == null) {
                database = Room.databaseBuilder(
                    context.applicationContext, SkyDataBase::class.java, "sky_huang_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = database
            }
            return database
        }
    }

}