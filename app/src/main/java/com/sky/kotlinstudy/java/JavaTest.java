package com.sky.kotlinstudy.java;

import android.content.Context;
import android.view.View;

import java.util.HashSet;
import java.util.Set;

/**
 * created skyHuang
 * data 2020/7/15
 **/
public class JavaTest {
    Context context;
    final int[] i=new int[]{1,2,3};
    final int anInt=1;
    final View mView=new View(context);
    public  void getSet() {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        Set<String> setStr = new HashSet<>();
        setStr.add("1");
        setStr.add("2");
    }
}
