package com.sky.kotlinstudy.test.constructor

/**
 *created skyHuang
 * data 2020/7/14
 **/

 class User(var name: String) {
    //    private var name: String
    private var age: Int = 1
    var hobby :String =""
    init {

    }

    constructor(name: String, age: Int) : this(name) {
        this.age = age
    }

    //函数
    fun getAge(name: String): Int {
        return age
    }

    fun getNameByAge(age: Int): String {
        return if (age == 1) {
            name
        } else {
            ""
        }
    }

}