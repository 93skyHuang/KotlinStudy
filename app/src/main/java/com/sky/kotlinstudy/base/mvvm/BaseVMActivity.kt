package com.sky.kotlinstudy.base.mvvm

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.sky.kotlinstudy.base.BaseActivity
import com.sky.kotlinstudy.ext.getVmClazz

/**
 *created skyHuang
 * data 2020/8/19
 **/
abstract class BaseVMActivity<VM: BaseViewModel> :BaseActivity(){

    lateinit var mViewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = createViewModel()
    }

    /**
     * 创建viewModel
     */
    private fun createViewModel(): VM {
        return ViewModelProvider(this).get(getVmClazz(this))
    }

}