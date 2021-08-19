package com.sky.kotlinstudy.model

import com.sky.kotlinstudy.room.DBBanner
import com.squareup.moshi.JsonClass

/**
 *
 * @Description:    [滚动栏Bean]
 * @Author:         skyHuang
 * @CreateDate:     2021/6/15 14:42
 */
@JsonClass(generateAdapter = true)
data class Banner(
    val desc: String,
    val title: String,
    val type: Int,
    val url: String,
    val order: String,
    val imagePath: String,
    val id: Int
)

/**
 * 网络数据转换为数据库数据
 */
fun List<Banner>.convertToDBBanners(): List<DBBanner> {
    return map {
        DBBanner(
            idKey = indexOf(it),
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