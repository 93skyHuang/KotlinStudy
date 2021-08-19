package com.sky.kotlinstudy.ui.home

import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.sky.kotlinstudy.R
import com.sky.kotlinstudy.model.Article
import com.sky.kotlinstudy.model.Banner
import timber.log.Timber

/**
 *
 * @Description:    []
 * @Author:         skyHuang
 * @CreateDate:     2021/8/12 15:53
 */

@BindingAdapter("setImageUrl")
fun ImageView.setImageUrl(banner: Banner) {
    Glide.with(context).load(banner.imagePath).into(this)
}

@BindingAdapter("bindData")
fun ViewPager.bindData(banners: List<Banner>?) {
    val adapter = adapter as BannerPagerAdapter
    adapter.refreshBanners(banners)
}


@BindingAdapter("bindRvData")
fun RecyclerView.bindData(banners: List<Article>?) {
    Timber.i(" skyHuang binddata $adapter")
    val adapter = adapter as HomeArticleAdapter
    adapter.submitList(banners)
}


@BindingAdapter("ivCollectedStatus")
fun ImageButton.setIvBG(a: Article) {
    setBackgroundResource(if (a.collect) R.drawable.ic_collected else R.drawable.ic_un_collected)
    setOnClickListener {

    }
}