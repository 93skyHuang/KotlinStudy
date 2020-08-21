package me.hgj.jetpackmvvm.callback.livedata

import androidx.lifecycle.MutableLiveData


/**
 * 作者　: skyHuang
 * 时间　: 2020/8/21
 * 描述　:自定义的Float类型 MutableLiveData 提供了默认值，避免取值的时候还要判空
 */
class FloatLiveData() : MutableLiveData<Float>() {
    override fun getValue(): Float {
        return super.getValue() ?: 0f
    }
}