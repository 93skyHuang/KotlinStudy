package com.sky.kotlinstudy.model

import com.sky.kotlinstudy.model.SystemChild
import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class SystemParent(val children: List<SystemChild>,
                        val courseId: Int,
                        val id: Int,
                        val name: String,
                        val order: Int,
                        val parentChapterId: Int,
                        val visible: Int,
                        val userControlSetTop: Boolean) : Serializable