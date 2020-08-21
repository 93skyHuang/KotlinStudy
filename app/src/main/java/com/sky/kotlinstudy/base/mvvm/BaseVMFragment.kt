package com.sky.kotlinstudy.base.mvvm

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.sky.kotlinstudy.base.BaseFragment
import com.sky.kotlinstudy.ext.getVmClazz

/**
 *created skyHuang
 * data 2020/8/20
 **/
abstract class BaseVMFragment<VM : BaseViewModel> : BaseFragment() {

    //ViewModel
    protected val viewModel: VM by lazy { initViewModel() }

    open fun initViewModel(): VM {
        return ViewModelProviders.of(this).get(getVmClazz(this))
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initState()
    }
}