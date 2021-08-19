package com.sky.kotlinstudy.ui.home

import android.os.Build
import android.os.Bundle
import com.sky.kotlinstudy.CommonWebViewActivity
import com.sky.kotlinstudy.R
import com.sky.kotlinstudy.base.mvvm.BaseVMDBFragment
import com.sky.kotlinstudy.databinding.HomeFragmentBinding
import timber.log.Timber

/**
 *
 * @Description:    []
 * @Author:         skyHuang
 * @CreateDate:     2021/4/26 17:44
 */
class HomeFragment : BaseVMDBFragment<HomeViewModel, HomeFragmentBinding>() {
    override fun layoutId(): Int {
        return R.layout.home_fragment
    }

    override fun initView() {
        mDataBinding.viewModel = mViewModel
        mDataBinding.homeRecyclerView.adapter = HomeArticleAdapter(ArticleItemClickListener(
            item = {

            }, collectViewOnClick = {

            })
        )
        mDataBinding.refreshLayout.apply {
            setRefreshHeader(mDataBinding.header)
            setRefreshFooter(mDataBinding.footer)
            setOnRefreshListener {
                mViewModel.refreshHome
            }
            setOnLoadMoreListener {

            }
        }
        mDataBinding.viewPager.adapter = context?.let {
            BannerPagerAdapter(BannerItemClickListener { banner ->
                val b = Bundle()
                b.putString("web_url", banner.url)
                b.putString("title", banner.title)
                navNextPage(CommonWebViewActivity::class.java, bundle = b)
            })
        }
    }

    override fun initData() {
//        mViewModel.refreshHome
        mViewModel.getBanner()
    }
}