package com.sky.kotlinstudy.base

import android.content.Context
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

/**
 *created skyHuang
 * data 2020/8/19
 * 基类
 **/
abstract class BaseActivity : AppCompatActivity() {
    /**
     * 是否需要使用DataBinding
     */
    private var isUserDb = false

    //R.layout.id
    @LayoutRes
    abstract fun layoutId(): Int

    //初始化
    protected abstract fun initView()

    //初始化数据
    protected abstract fun initData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!isUserDb) {
            setContentView(layoutId())
        } else {
            initDataBind()
        }
        preInit()
        initView()
        initData()
    }


    open fun preInit() {

    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (ev.action == MotionEvent.ACTION_DOWN) {
            val v = currentFocus ?: return super.dispatchTouchEvent(ev)
            if (isShouldHideKeyboard(v, ev)) {
                hideSoftInput(v)
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    /**
     * 隐藏键盘
     *
     * @param view 焦点控件
     */
    protected fun hideSoftInput(view: View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }

    // 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘
    private fun isShouldHideKeyboard(v: View, event: MotionEvent): Boolean {
        if (v is EditText) {
            val l = intArrayOf(0, 0)
            v.getLocationInWindow(l)
            val left = l[0]
            val top = l[1]
            val bottom = top + v.height
            val right = left + v.width
            return !(event.x > left && event.x < right
                    && event.y > top && event.y < bottom)
        }
        return false
    }


    fun userDataBinding(isUserDb: Boolean) {
        this.isUserDb = isUserDb
    }

    /**
     * 供子类BaseVmDbActivity 初始化Databinding操作
     */
    open fun initDataBind() {}
}