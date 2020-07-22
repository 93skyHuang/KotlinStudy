package com.sky.kotlinstudy

/**
 *created skyHuang
 * data 2020/7/14
 **/

fun topMethod(){
    println("top-level")
}

object SingletonTest {
    open class A {
        open fun method() {

        }
    }

    interface B {
        fun interfaceMethod()
    }

    object C : A(), B {
        override fun interfaceMethod() {
            TODO("Not yet implemented")
        }
    }
}