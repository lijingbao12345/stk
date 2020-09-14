package com.example.goods.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.goods.R;
import com.example.goods.basemvp.bean.homebanner.HomeBannerBean;
import com.example.goods.basemvp.bean.homebanner.HomeTestOneBean;
import com.example.goods.databinding.ItemHometestoneBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeTestOneAdapter extends DelegateAdapter.Adapter<HomeTestOneAdapter.ViewHolder> {
    Context context;
    LayoutHelper layoutHelper;

    public List<HomeTestOneBean.DataBean.BrandListBean> list2 = new ArrayList<>();
    private  ItemHometestoneBinding itemHometestoneBinding;
    private int count = 1;


    public HomeTestOneAdapter(Context context, LayoutHelper layoutHelper,int count) {
        this.context = context;
        this.layoutHelper = layoutHelper;
        this.count = count;
    }

    public void setList2(List<HomeTestOneBean.DataBean.BrandListBean> list2) {
        this.list2.addAll(list2);
        notifyDataSetChanged();
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemHometestoneBinding binding = ItemHometestoneBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      /*  itemHometestoneBinding.itemHomeTestoneRv.setLayoutManager(new GridLayoutManager(context,2));
        BrandmanufacturerAdapter brandmanufacturerAdapter = new BrandmanufacturerAdapter(context,list2);
        itemHometestoneBinding.itemHomeTestoneRv.setAdapter(brandmanufacturerAdapter);*/
    }

    @Override
    public int getItemCount() {
        return count;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull ItemHometestoneBinding itemView) {
            super(itemView.getRoot());
            itemHometestoneBinding = itemView;

        }
    }
}
