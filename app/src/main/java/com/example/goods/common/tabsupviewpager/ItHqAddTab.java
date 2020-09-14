package com.example.goods.common.tabsupviewpager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.goods.R;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class ItHqAddTab {

    public  static void addTab(TabLayout tabLayout, ViewPager viewPager, final List<Fragment> fragment, final List<String> title, FragmentManager fragmentManager){

        /**
         * 预加载
         */
        viewPager.setOffscreenPageLimit(fragment.size());

        viewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                return fragment.get(position);
            }
            @Override
            public int getCount() {
                return fragment.size();
            }
            @Override
            public CharSequence getPageTitle(int position) {
                return title.get(position);
            }
        });
       // TabLayout关联ViewPager
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.home_tab);
        tabLayout.getTabAt(1).setIcon(R.drawable.classification_tab);
        tabLayout.getTabAt(2).setIcon(R.drawable.specialtopic_tab);
        tabLayout.getTabAt(3).setIcon(R.drawable.my_tab);
    }
}