package com.example.goods.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.goods.R;
import com.example.goods.basemvp.bean.homebanner.HomeBannerBean;
import com.example.goods.basemvp.bean.homebanner.HomeTestOneBean;
import com.example.goods.databinding.ItemBrandmanufacturerBinding;


import java.util.ArrayList;
import java.util.List;

public class BrandmanufacturerAdapter extends RecyclerView.Adapter<BrandmanufacturerAdapter.ViewHolder> {
    Context context;
   public List<HomeTestOneBean.DataBean.BrandListBean> beanList = new ArrayList<>();
        List<String> list;

    private ItemBrandmanufacturerBinding binding;
    private int soc = 4;

    public BrandmanufacturerAdapter(Context context,int soc) {
        this.context = context;
        this.soc = soc;
    }
/*
    public void setBeanList(List<HomeTestOneBean.DataBean.BrandListBean> beanList) {
        this.beanList.addAll(beanList);
        notifyDataSetChanged();
    }*/
      public BrandmanufacturerAdapter(Context context, List<String> beanList) {
        this.context = context;
        this.list = beanList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemBrandmanufacturerBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      /*  HomeTestOneBean.DataBean.BrandListBean brandListBean = beanList.get(position);*/
       String s = list.get(position);
        binding.textView4.setText(s);
      /*  binding.textView4.setText(brandListBean.getName());
        binding.textView5.setText(brandListBean.getId()+"");
        binding.textView6.setText(brandListBean.getFirstLetter());
        Glide.with(context).load(brandListBean.getBigPic()).into(binding.itemBrandmanufacturerImg);*/
    }

    @Override
    public int getItemCount() {
       return 4;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull ItemBrandmanufacturerBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
