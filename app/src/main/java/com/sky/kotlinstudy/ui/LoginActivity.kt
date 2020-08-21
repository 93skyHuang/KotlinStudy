package com.sky.kotlinstudy.ui

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.databinding.adapters.ImageViewBindingAdapter
import com.sky.kotlinstudy.R
import com.sky.kotlinstudy.base.mvvm.BaseVMDBActivity
import com.sky.kotlinstudy.databinding.LoginActivityBinding
import com.sky.kotlinstudy.viewmodel.LoginViewModel

/**
 *created skyHuang
 * data 2020/8/21
 * 登录页
 **/
class LoginActivity : BaseVMDBActivity<LoginViewModel, LoginActivityBinding>() {

    override fun layoutId(): Int {
        return R.layout.login_activity
    }

    override fun initView() {
        mDatabind.viewmodel = mViewModel
        mDatabind.viewClick = ViewAction()
    }

    override fun initData() {

    }

    inner class ViewAction {
        fun login() {

        }
    }

}