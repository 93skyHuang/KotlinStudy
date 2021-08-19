package com.sky.kotlinstudy

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sky.kotlinstudy.base.mvvm.BaseVMActivity
import com.sky.kotlinstudy.ui.home.HomeFragment
import com.sky.kotlinstudy.ui.mine.MineFragment
import com.sky.kotlinstudy.ui.progect.ProjectFragment
import com.sky.kotlinstudy.ui.public.PublicFragment
import com.sky.kotlinstudy.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.main_activity.*
import java.util.*

class MainActivity : BaseVMActivity<MainViewModel>() {

    private var currentPageIndex = -1

    private val homeFragment by lazy { HomeFragment() } // 首页
    private val projectFragment by lazy { ProjectFragment() } // 项目
    private val publicAccountFragment by lazy { PublicFragment() } //公众号
    private val mineFragment by lazy { MineFragment() } // 我的
    private val fragments: ArrayList<Fragment> by lazy {
        arrayListOf<Fragment>(
            homeFragment, projectFragment, publicAccountFragment, mineFragment
        )
    }
    private val onNavigationItemSelected = BottomNavigationView.OnNavigationItemSelectedListener {
        when (it.itemId) {
            R.id.item_home_page -> {
                switchFragment(0)
            }
            R.id.item_project -> {
                switchFragment(1)
            }
            R.id.item_public_account -> {
                switchFragment(2)
            }
            R.id.item_mine -> {
                switchFragment(3)
            }
        }
        true
    }

    override fun layoutId(): Int {
        return R.layout.main_activity
    }

    override fun initView() {
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelected)
        switchFragment(0)
    }

    override fun initData() {

    }

    private fun switchFragment(index: Int) {
        if (currentPageIndex != index) {
            val trx = supportFragmentManager.beginTransaction()
            if (currentPageIndex != -1)
                trx.hide(fragments[currentPageIndex])
            if (!fragments[index].isAdded)
                trx.add(fragmentContent.id, fragments[index])
            trx.show(fragments[index]).commitAllowingStateLoss()
        }
        currentPageIndex = index
        setTitleBar()
    }

    /**
     * 设置title bar
     */
    private fun setTitleBar() {
        when (currentPageIndex) {
            0 -> {
                tvTitle.visibility = View.VISIBLE
                tvTitle.text = "首页"
            }
            else -> tvTitle.visibility = View.GONE
        }
    }
}
