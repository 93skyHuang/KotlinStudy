package com.sky.kotlinstudy.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Title(val title: Int, val icon: Int, val action: () -> Unit)