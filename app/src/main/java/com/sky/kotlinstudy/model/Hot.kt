package com.sky.kotlinstudy.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Hot(val id: Int,
               val link: String,
               val name: String,
               val order: Int,
               val visible: Int,
               val icon: String)