package com.sky.kotlinstudy.ext

import java.lang.reflect.ParameterizedType

/**
 *created skyHuang
 * data 2020/8/21
 * 获取当前类绑定的泛型ViewModel-clazz
 **/

@Suppress("UNCHECKED_CAST")
fun <VM> getVmClazz(obj: Any): VM {
    return (obj.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as VM
}