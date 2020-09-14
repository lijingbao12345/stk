package com.example.goods.basemvp.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;


import com.example.goods.basemvp.prestener.IBasePrestener;
import com.example.goods.basemvp.view.IBaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseFragment<P extends IBasePrestener> extends Fragment implements IBaseView {

    protected P mPresenter;
    protected Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        context=getContext();
        return getInflate(inflater,container);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
            initData();
        }

    }

    protected abstract View getInflate(LayoutInflater inflater, ViewGroup container);

    protected abstract void initView();

    protected abstract P createPresenter();

    protected abstract void initData();

    @Override
    public void showTips(String tips) {

    }

    @Override
    public void showLoading(int visible) {

    }
}
