package com.example.goods.basemvp.ui.mainfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.goods.R;
import com.example.goods.basemvp.base.BaseFragment;
import com.example.goods.basemvp.prestener.IBasePrestener;
import com.example.goods.databinding.FragmentClassifyBinding;

public class ClassifyFragment extends BaseFragment {

    private FragmentClassifyBinding binding;

    @Override
    protected View getInflate(LayoutInflater inflater, ViewGroup container) {
        binding = FragmentClassifyBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected IBasePrestener createPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }
}
