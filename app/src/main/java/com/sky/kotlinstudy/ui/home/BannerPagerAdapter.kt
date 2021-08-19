package com.sky.kotlinstudy.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.sky.kotlinstudy.databinding.HomeBannerItemBinding
import com.sky.kotlinstudy.model.Banner

/**
 *
 * @Description:    [轮询适配器]
 * @Author:         skyHuang
 * @CreateDate:     2021/6/11 15:37
 */
class BannerPagerAdapter(private val bannerItemClickListener: BannerItemClickListener) : PagerAdapter() {
    private val TAG = "BannerPagerAdapter"
    private var _banners: List<Banner>? = null

    fun refreshBanners(banners: List<Banner>?) {
        banners?.let {
            _banners = banners
            notifyDataSetChanged()
        }
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding = HomeBannerItemBinding.inflate(LayoutInflater.from(container.context))
        binding.banner = _banners!![position]
        binding.click = bannerItemClickListener
        binding.executePendingBindings()
        container.addView(binding.root)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }

    override fun isViewFromObject(view: View, ob: Any): Boolean {
        return view == ob
    }

    override fun getCount(): Int {
        return _banners?.size ?: 0
    }
}
class BannerItemClickListener(private val clickListener: (banner: Banner) -> Unit) {
    fun onClick(banner: Banner) = clickListener(banner)
}