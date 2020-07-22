package com.sky.kotlinstudy.constructor

/**
 *created skyHuang
 * data 2020/7/14
 * 构造器
 **/
class Student(val name: String, var age: Int) {
    var sex: Int = 0
    var hobby: String

    init {
        sex=1
        hobby="足球"
    }

    constructor(name: String, age: Int, sex: Int) : this(name, age) {
        this.sex = sex
    }

    constructor(name: String, age: Int, sex: Int, hobby: String) : this(name, age) {
        this.hobby = hobby
        this.sex = sex
    }

    fun show() {
        println(
            """
            name=$name
            name.length= ${name.length}
            age=$age sex=$sex hobby=$hobby
        """.trimIndent()
        )
    }
}