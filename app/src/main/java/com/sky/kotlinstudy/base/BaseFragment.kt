package com.sky.kotlinstudy.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sky.kotlinstudy.common.navNextPage

/**
 *created skyHuang
 * data 2020/8/19
 **/
abstract class BaseFragment : Fragment() {
    private  val TAG = "BaseFragment"
    lateinit var mActivity: AppCompatActivity

    //R.layout.id
    @LayoutRes
    abstract fun layoutId(): Int

    //初始化
    protected abstract fun initView()

    //初始化数据
    protected abstract fun initData()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return getContentView(layoutId(), inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preInit()
        initView()
        initData()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as AppCompatActivity
    }

    open fun preInit() {

    }

    /**
     * 兼容dataBinding
     */
    open fun getContentView(
        @LayoutRes layoutId: Int, inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(layoutId(), container, false)
    }

    protected fun <T : Activity> navNextPage(
        targetActivity: Class<T>,
        bundle: Bundle? = null,
        requestCode: Int? = null,
        login: Boolean = false
    ): Activity? {
        return activity?.navNextPage(targetActivity, bundle, requestCode, login)
    }
}