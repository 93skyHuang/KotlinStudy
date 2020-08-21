package me.hgj.jetpackmvvm.callback.livedata

import androidx.lifecycle.MutableLiveData


/**
 * 作者　: skyHuang
 * 时间　: 2020/8/21
 * 描述　:自定义的Short类型 MutableLiveData 提供了默认值，避免取值的时候还要判空
 */
class ByteLiveData : MutableLiveData<Byte>() {
    override fun getValue(): Byte {
        return super.getValue() ?: 0
    }
}