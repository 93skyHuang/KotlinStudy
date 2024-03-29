package com.sky.kotlinstudy.model

import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class ArticleList(
    val offset: Int,
    val size: Int,
    val total: Int,
    val pageCount: Int,
    val curPage: Int,
    val over: Boolean,
    val datas: List<Article>
) : Serializable