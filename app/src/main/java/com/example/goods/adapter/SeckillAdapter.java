package com.example.goods.adapter;

import android.content.Context;
import android.util.Log;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.util.TimeUtils;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.goods.R;
import com.example.goods.common.time.PeterTimeCountRefresh;
import com.example.goods.databinding.ItemSeckillBinding;

import java.util.List;

public class SeckillAdapter extends DelegateAdapter.Adapter<SeckillAdapter.ViewHolder> {
    Context context;
    LayoutHelper singleLayoutHelper;
    int count = 1;
    private ItemSeckillBinding binding;
//秒杀
    public SeckillAdapter(Context context, LayoutHelper singleLayoutHelper, int count) {
        this.context = context;
        this.singleLayoutHelper = singleLayoutHelper;
        this.count = count;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        binding = ItemSeckillBinding.inflate(LayoutInflater.from(context), parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        PeterTimeCountRefresh timer = new PeterTimeCountRefresh(600000, 1000,  binding.itemSeckillCountdownTv);
        timer.onTick(1);
        timer.start();



    }

    @Override
    public int getItemCount() {
        return count;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull ItemSeckillBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
