package com.sky.kotlinstudy.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sky.kotlinstudy.model.Banner

/**
 *
 * @Description:    []
 * @Author:         skyHuang
 * @CreateDate:     2021/8/6 10:50
 */

@Entity(tableName = "dbBanner")
data class DBBanner constructor(
    @PrimaryKey()
    val idKey: Int,
    val id:Int,
    val desc: String,
    val title: String,
    val type: Int,
    val url: String,
    val order: String,
    val imagePath: String
)

/**
 * 数据库数据转换为UI数据
 */
fun List<DBBanner>.convertToBanners(): List<Banner> {
    return map {
        Banner(
            id = it.id,
            desc = it.desc,
            title = it.title,
            type = it.type,
            url = it.url,
            order = it.order,
            imagePath = it.imagePath
        )
    }
}