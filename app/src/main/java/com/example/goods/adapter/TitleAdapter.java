package com.example.goods.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.goods.R;
import com.example.goods.basemvp.bean.homebanner.HomeTestOneBean;
import com.example.goods.databinding.ItemTitle2Binding;

import java.util.ArrayList;
import java.util.List;

public class TitleAdapter extends DelegateAdapter.Adapter<TitleAdapter.ViewHolder> {
    Context context;
    LayoutHelper layoutHelper;
   public List<String> list ;

    private  ItemTitle2Binding itemTitle2Binding;

    public TitleAdapter(Context context, LayoutHelper layoutHelper, List<String> list) {
        this.context = context;
        this.layoutHelper = layoutHelper;
        this.list = list;
    }



    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTitle2Binding view = ItemTitle2Binding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String s = list.get(position);
        /*String s1 = list.set(0, "话题");
        String s2 = list.set(1, "优选");
        String s3 = list.set(2, "特惠");
        String s4 = list.set(3, "签到");*/
        itemTitle2Binding.title2Tv.setText(s);
       /* itemTitle2Binding.title2Tv.setText(s2);
        itemTitle2Binding.title2Tv.setText(s3);
        itemTitle2Binding.title2Tv.setText(s4);*/
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull ItemTitle2Binding itemView) {
            super(itemView.getRoot());
            itemTitle2Binding = itemView;
        }
    }
}
