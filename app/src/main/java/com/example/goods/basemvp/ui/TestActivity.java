package com.example.goods.basemvp.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

import com.example.goods.R;
import com.example.goods.adapter.TabAdapter;
import com.example.goods.basemvp.base.BaseActivity;
import com.example.goods.basemvp.prestener.IBasePrestener;
import com.example.goods.basemvp.ui.mainfragment.ClassifyFragment;
import com.example.goods.basemvp.ui.mainfragment.HomeFragment;
import com.example.goods.basemvp.ui.mainfragment.MyFragment;
import com.example.goods.basemvp.ui.mainfragment.SpecialTopicFragment;
import com.example.goods.common.tabsupviewpager.ItHqAddTitle;
import com.example.goods.common.tabsupviewpager.ItHqAddtab2;
import com.example.goods.databinding.ActivityTestBinding;
import com.example.goods.utils.LogUtils;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends BaseActivity {
    private ActivityTestBinding binding;
    private TabLayout.Tab tab;


    @Override
    protected View initLayout() {
        binding = ActivityTestBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    protected IBasePrestener setPrestener() {
        return null;
    }

    @Override
    protected void initView() {
        Resources resources = getResources();
        String[] stringArray = resources.getStringArray(R.array.our_name);
        //获得fragment对象
        HomeFragment homeFragment = new HomeFragment();
        MyFragment myFragment = new MyFragment();
        ClassifyFragment classifyFragment = new ClassifyFragment();
        SpecialTopicFragment specialTopicFragment = new SpecialTopicFragment();
        //将其放入array数组，然后展示
        List<Fragment> strings = ItHqAddtab2.addTitle(homeFragment, myFragment, classifyFragment, specialTopicFragment);
        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager(), strings);
        binding.testVp.setAdapter(tabAdapter);
        binding.testTab.setupWithViewPager(binding.testVp);
        //这就是动态设置tab_text，想设置多少条直接在数组里面设置就ok
        for (int i = 0; i < stringArray.length; i++) {
            LogUtils.d("ss" + stringArray[i]);
            tab = binding.testTab.getTabAt(i).setText(stringArray[i]);
            //tab下划线颜色
//            binding.tab.setSelectedTabIndicatorColor(intArray[j]);
        }
//跟据条件选择背景颜色操作
        int[] intArray = resources.getIntArray(R.array.text_Color);
        for (int j = 0; j < intArray.length; j++) {
            if (j == 1) {
                binding.testTab.setBackgroundColor(intArray[j]);
            } else if (j == 2) {
                binding.tv3.setBackgroundColor(intArray[j]);
            } else if (j == 3){
                binding.tv3.setBackgroundColor(intArray[j]);
            }
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    public void showTips(String tips) {

    }

    @Override
    public void showLoading(int visible) {

    }
}