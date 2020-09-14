package com.example.goods.common.tabsupviewpager;

import androidx.fragment.app.Fragment;

import java.util.Arrays;
import java.util.List;

public class ItHqAddFragment {
    public static List<Fragment> addFragment(Fragment ... fragments){

       Fragment[] m = fragments;

        List<Fragment> fragmentList = Arrays.asList(m);

        return fragmentList;
    }
}
