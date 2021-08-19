package com.sky.kotlinstudy.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Navigation(val articles: List<Article>,
                      val cid: Int,
                      val name: String)