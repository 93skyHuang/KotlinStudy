package com.sky.kotlinstudy.widget.supertv;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.viewpager.widget.ViewPager;

import java.util.HashMap;
import java.util.Map;

/**
 * 轮询图
 */
public class BannerViewPager extends ViewPager {

    private View mLeft;
    private View mRight;

    private float mTrans;
    private float mScale;

    private static final float MIN_SCALE = 0.6f;
    private Map<Integer, View> mChildren = new HashMap<Integer, View>();

    /*
     * 要有两个构造方法
     */
    public BannerViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BannerViewPager(Context context) {
        super(context);
    }

    /**
     * 重写的方法
     */
    @Override
    protected void onPageScrolled(int position, float offset, int offsetPixels) {

        // Log.e("TAG", "position =" + position + ",offset = " + offset);
        mLeft = mChildren.get(position);
        mRight = mChildren.get(position + 1);

        animStack(mLeft, mRight, offset, offsetPixels);// 创建动画效果

        super.onPageScrolled(position, offset, offsetPixels);
    }

    private void animStack(View left, View right, float offset, int offsetPixels) {
        if (right != null) {

            // 从0-1页，offset:0`1
            mScale = (1 - MIN_SCALE) * offset + MIN_SCALE;

            mTrans = -getWidth() - getPageMargin() + offsetPixels;

//            right.setScaleX(right, mScale);
//            right.setScaleY(right, mScale);
//
//            right.setTranslationX(right, mTrans);
        }
        if (left != null) {
            left.bringToFront();
        }
    }
}