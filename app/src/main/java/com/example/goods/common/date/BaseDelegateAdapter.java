package com.example.goods.common.date;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.goods.basemvp.base.BaseAdapter;

public class BaseDelegateAdapter extends DelegateAdapter.Adapter<BaseAdapter.BaseViewHolder> {

    private int mLayoutId;
    private int mCount;
    private LayoutHelper mLayoutHelper;


    public BaseDelegateAdapter(LayoutHelper layoutHelper, int layoutId,int count){
        mLayoutId = layoutId;
        mCount = count;
        mLayoutHelper = layoutHelper;
    }



    @Override
    public BaseAdapter.BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mLayoutId,parent,false);
        return new BaseAdapter.BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseAdapter.BaseViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mCount;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mLayoutHelper;
    }
}
