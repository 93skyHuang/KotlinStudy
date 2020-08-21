package com.sky.kotlinstudy.test.constructor

/**
 *created skyHuang
 * data 2020/7/15
 **/


class Teacher private constructor(val name: String) {

    init {

    }

    companion object {
        private val teacher: Teacher =
            Teacher("222")

        fun getTeacher(): Teacher {
          return teacher
        }
    }
}
