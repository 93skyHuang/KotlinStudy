package com.sky.kotlinstudy.base.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 *created skyHuang
 * data 2020/8/21
 * 使用这个基类 无法灵活使用ViewModel的Factory来初始化带参构造方法
 **/
abstract class BaseVMDBFragment<VM : BaseViewModel, DB : ViewDataBinding> : BaseVMFragment<VM>() {
    private val TAG = "BaseVMDBFragment"
    lateinit var mDataBinding: DB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mDataBinding = DataBindingUtil.inflate(inflater, layoutId(), container, false)
        mDataBinding.lifecycleOwner = this
        return mDataBinding.root
    }
}