package com.example.goods;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.goods.basemvp.base.BaseActivity;
import com.example.goods.basemvp.base.TitlebarView;
import com.example.goods.basemvp.insertface.TabVIewPager;
import com.example.goods.basemvp.prestener.IBasePrestener;
import com.example.goods.basemvp.ui.mainfragment.ClassifyFragment;
import com.example.goods.basemvp.ui.mainfragment.HomeFragment;
import com.example.goods.basemvp.ui.mainfragment.MyFragment;
import com.example.goods.basemvp.ui.mainfragment.SpecialTopicFragment;
import com.example.goods.common.tabsupviewpager.ItHqAddFragment;
import com.example.goods.common.tabsupviewpager.ItHqAddTab;
import com.example.goods.common.tabsupviewpager.ItHqAddTitle;
import com.example.goods.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import static com.example.goods.basemvp.base.BaseRegularExpression.QQ;
import static com.example.goods.basemvp.base.BaseRegularExpression.isMatch;

public class MainActivity extends BaseActivity {
    //变量，控件，字段，常量按照组来分层如：
    //控件
    //变量

    //字段
    //常量（正宗常量写法）
    public final String MESSAGE = "com.example.goods.MainActivity";
    private ActivityMainBinding binding;


    @Override
    protected View initLayout() {
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        return binding.getRoot();
    }


    @Override
    protected void initView() {
        binding.title2.setTitleSize(20);

        binding.title2.setTitle("Mall商城");

        binding.title2.setLeftDrawable(R.mipmap.notify);

        binding.title2.setRightDrawable(R.mipmap.shoppingtrolley_one);

        binding.title2.setRightDrawable_img(R.mipmap.back_one);

        binding.title2.setOnViewClick(new TitlebarView.onViewClick() {
            @Override
            public void leftClick() {
                Toast.makeText(MainActivity.this, "左边", Toast.LENGTH_SHORT).show();

                //成功
                if (isMatch(QQ, "2741702606") == true) {
                    Toast.makeText(MainActivity.this, "成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void rightClick() {
                Toast.makeText(MainActivity.this, "右边", Toast.LENGTH_SHORT).show();
            }
        });

        ArrayList<Fragment> fragments = new ArrayList<>();
        //fragment
        fragments.add(new HomeFragment());
        fragments.add(new ClassifyFragment());
        fragments.add(new SpecialTopicFragment());
        fragments.add(new MyFragment());

        List<String> strings = ItHqAddTitle.addTitle("首页", "分类", "专题", "我的");

        ItHqAddFragment.addFragment(new HomeFragment(), new ClassifyFragment(), new SpecialTopicFragment(), new MyFragment());
        //viewpager适配器，选择器tab图片可以在里面写
        ItHqAddTab.addTab(binding.mainTab, binding.mainViewpager, fragments, strings, getSupportFragmentManager());


    }

    @Override
    protected IBasePrestener setPrestener() {
        return null;
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